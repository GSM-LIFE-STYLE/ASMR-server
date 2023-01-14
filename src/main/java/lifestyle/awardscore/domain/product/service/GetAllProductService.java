package lifestyle.awardscore.domain.product.service;

import lifestyle.awardscore.domain.product.entity.Product;
import lifestyle.awardscore.domain.product.facade.ProductFacade;
import lifestyle.awardscore.domain.product.presentation.dto.response.AllProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllProductService {

    private final ProductFacade productFacade;

    /**
     * 등록된 모든 상품을 조회하는 서비스
     * @return products
     */
    public List<AllProductResponse> execute() {
        List<Product> products = productFacade.getAllProductEntity();
        List<AllProductResponse> responses = productFacade.productEntityListToDtoList(products);
        return responses;
    }
}
