package lifestyle.awardscore.domain.product.service;

import lifestyle.awardscore.domain.product.facade.ProductFacade;
import lifestyle.awardscore.domain.product.presentation.dto.request.RegisterProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterProductService {

    private final ProductFacade productFacade;

    public void execute(RegisterProductRequest request) {
        productFacade.saveProductEntity(request.toEntity());
    }
}
