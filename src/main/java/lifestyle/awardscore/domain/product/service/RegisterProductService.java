package lifestyle.awardscore.domain.product.service;

import lifestyle.awardscore.domain.product.facade.ProductFacade;
import lifestyle.awardscore.domain.product.presentation.dto.request.RegisterProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterProductService {

    private final ProductFacade productFacade;

    @Transactional(rollbackFor = Exception.class)
    public void execute(RegisterProductRequest request) {
        productFacade.saveProductEntity(request.toEntity());
    }

}
