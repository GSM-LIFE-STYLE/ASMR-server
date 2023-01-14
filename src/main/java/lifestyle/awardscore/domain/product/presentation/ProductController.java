package lifestyle.awardscore.domain.product.presentation;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lifestyle.awardscore.domain.product.presentation.dto.request.RegisterProductRequest;
import lifestyle.awardscore.domain.product.presentation.dto.request.UpdateProductRequest;
import lifestyle.awardscore.domain.product.presentation.dto.response.AllProductResponse;
import lifestyle.awardscore.domain.product.presentation.dto.response.ProductResponse;
import lifestyle.awardscore.domain.product.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final RegisterProductService registerProductService;
    private final GetAllProductService getAllProductService;
    private final GetProductService getProductService;
    private final UpdateProductService updateProductService;
    private final DeleteProductService deleteProductService;

    @PostMapping
    @ApiOperation(value = "아이템 등록", notes = "아이템 등록")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "RefreshToken", value = "로그인 성공 후 refresh_token", required = false, dataType = "String", paramType = "header")
    })
    public ResponseEntity<Void> registerProduct(@Valid @RequestBody RegisterProductRequest request) {
        registerProductService.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    @ApiOperation(value = "아이템 전체 조회", notes = "아이템 전체 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "RefreshToken", value = "로그인 성공 후 refresh_token", required = false, dataType = "String", paramType = "header")
    })
    public ResponseEntity<List<AllProductResponse>> getAllProducts() {
        List<AllProductResponse> responses = getAllProductService.execute();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "아이템 상세 조회", notes = "아이템 상세 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "RefreshToken", value = "로그인 성공 후 refresh_token", required = false, dataType = "String", paramType = "header")
    })
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id) {
        ProductResponse response = getProductService.execute(id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    @ApiOperation(value = "아이템 수정", notes = "아이템 수정")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "RefreshToken", value = "로그인 성공 후 refresh_token", required = false, dataType = "String", paramType = "header")
    })
    public ResponseEntity<Void> updateProduct(@PathVariable Long id, @RequestBody @Valid UpdateProductRequest request) {
        updateProductService.execute(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "아이템 삭제", notes = "아이템 삭제")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "RefreshToken", value = "로그인 성공 후 refresh_token", required = false, dataType = "String", paramType = "header")
    })
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        deleteProductService.execute(id);
        return ResponseEntity.ok().build();
    }

}
