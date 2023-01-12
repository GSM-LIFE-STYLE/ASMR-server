package lifestyle.awardscore.domain.product.service;

import lifestyle.awardscore.domain.product.entity.Product;
import lifestyle.awardscore.domain.product.facade.ProductFacade;
import lifestyle.awardscore.domain.product.presentation.dto.request.UpdateProductRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Getter
@RequiredArgsConstructor
public class UpdateProductService {

    private final ProductFacade productFacade;

    @Transactional(rollbackFor = Exception.class)
    public void execute(Long id , UpdateProductRequest request) {
        Product product = productFacade.getProductEntityById(id);
    }
}
