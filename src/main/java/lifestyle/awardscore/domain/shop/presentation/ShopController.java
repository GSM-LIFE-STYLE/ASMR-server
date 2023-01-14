package lifestyle.awardscore.domain.shop.presentation;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lifestyle.awardscore.domain.shop.presentation.dto.RegisterShopRequest;
import lifestyle.awardscore.domain.shop.service.RegisterShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shop")
public class ShopController {

    private final RegisterShopService registerShopService;

    @PostMapping
    @ApiOperation(value = "상점마켓 등록", notes = "상점마켓 등록")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "RefreshToken", value = "로그인 성공 후 refresh_token", required = false, dataType = "String", paramType = "header")
    })
    public ResponseEntity<Void> registerShop(RegisterShopRequest request) {
        registerShopService.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
