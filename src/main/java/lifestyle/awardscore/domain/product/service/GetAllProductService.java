package lifestyle.awardscore.domain.product.service;

import lifestyle.awardscore.domain.product.facade.ProductFacade;
import lifestyle.awardscore.domain.product.presentation.dto.response.AllProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllProductService {

    private final ProductFacade productFacade;

    public List<AllProductResponse> getAllProducts() {
        productFacade.
    }
}
