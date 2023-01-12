package lifestyle.awardscore.domain.product.facade;

import lifestyle.awardscore.domain.product.entity.Product;
import lifestyle.awardscore.domain.product.exception.NotFoundProductException;
import lifestyle.awardscore.domain.product.repository.ProductRepository;
import lombok.*;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class ProductFacade {

    private final ProductRepository productRepository;

    public Product getProductEntityById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundProductException("등록되지 않은 상품입니다."));
    }

    public void saveProductEntity(Product product) {
        productRepository.save(product);
    }
}
