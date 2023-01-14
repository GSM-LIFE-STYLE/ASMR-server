package lifestyle.awardscore.domain.shop.presentation;

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
    public ResponseEntity<Void> registerShop(RegisterShopRequest request) {
        registerShopService.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
