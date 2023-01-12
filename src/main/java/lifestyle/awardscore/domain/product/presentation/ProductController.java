package lifestyle.awardscore.domain.product.presentation;

import lifestyle.awardscore.domain.product.presentation.dto.request.RegisterProductRequest;
import lifestyle.awardscore.domain.product.presentation.dto.request.UpdateProductRequest;
import lifestyle.awardscore.domain.product.presentation.dto.response.AllProductResponse;
import lifestyle.awardscore.domain.product.presentation.dto.response.ProductResponse;
import lifestyle.awardscore.domain.product.service.GetAllProductService;
import lifestyle.awardscore.domain.product.service.GetProductService;
import lifestyle.awardscore.domain.product.service.RegisterProductService;
import lifestyle.awardscore.domain.product.service.UpdateProductService;
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

    @PostMapping
    public ResponseEntity<Void> registerProduct(@Valid @RequestBody RegisterProductRequest request) {
        registerProductService.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<AllProductResponse>> getAllProducts() {
        List<AllProductResponse> responses = getAllProductService.execute();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id) {
        ProductResponse response = getProductService.execute(id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable Long id, @RequestBody @Valid UpdateProductRequest request) {
        updateProductService.execute(id, request);
        return ResponseEntity.ok().build();
    }

}
