package lifestyle.awardscore.domain.product.presentation;

import lifestyle.awardscore.domain.product.presentation.dto.request.RegisterProductRequest;
import lifestyle.awardscore.domain.product.service.RegisterProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final RegisterProductService registerProductService;

    @PostMapping
    public ResponseEntity<Void> registerProduct(@Valid @RequestBody RegisterProductRequest request) {
        registerProductService.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
