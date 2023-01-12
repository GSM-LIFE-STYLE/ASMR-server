package lifestyle.awardscore.domain.product.facade;

import lifestyle.awardscore.domain.product.entity.Product;
import lifestyle.awardscore.domain.product.exception.NotFoundProductException;
import lifestyle.awardscore.domain.product.presentation.dto.response.AllProductResponse;
import lifestyle.awardscore.domain.product.presentation.dto.response.ProductResponse;
import lifestyle.awardscore.domain.product.repository.ProductRepository;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class ProductFacade {

    private final ProductRepository productRepository;

    public Product getProductEntityById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundProductException("등록되지 않은 상품입니다."));
    }

    public List<Product> getAllProductEntity() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) {
            throw new NotFoundProductException("상품이 존재하지 않습니다.");
        }
        return products;
    }

    public ProductResponse productEntityToDto(Product product) {
        return ProductResponse.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .price(product.getPrice())
                .description(product.getDescription())
                .build();
    }

    public List<AllProductResponse> productEntityListToDtoList(List<Product> products) {
        List<AllProductResponse> responses = products.stream()
                .map(p -> new AllProductResponse(p.getProductId(), p.getProductName(), p.getDescription()))
                .collect(Collectors.toList());
        return responses;
    }

    public void saveProductEntity(Product product) {
        productRepository.save(product);
    }

    public void deleteProductEntityById(Long id) {
        productRepository.deleteById(id);
    }
}
