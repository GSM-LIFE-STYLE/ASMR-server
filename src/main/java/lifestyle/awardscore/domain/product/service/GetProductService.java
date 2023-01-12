package lifestyle.awardscore.domain.product.service;

import lifestyle.awardscore.domain.product.entity.Product;
import lifestyle.awardscore.domain.product.facade.ProductFacade;
import lifestyle.awardscore.domain.product.presentation.dto.response.ProductResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetProductService {

    private final ProductFacade productFacade;

    public ProductResponse execute(Long productId) {
        Product product = productFacade.getProductEntityById(productId);
        ProductResponse response = productFacade.productEntityToDto(product);
        return response;
    }
}
