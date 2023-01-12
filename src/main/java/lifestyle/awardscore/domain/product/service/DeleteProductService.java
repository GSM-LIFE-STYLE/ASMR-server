package lifestyle.awardscore.domain.product.service;

import lifestyle.awardscore.domain.product.facade.ProductFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteProductService {

    private final ProductFacade productFacade;

    @Transactional(rollbackFor = Exception.class)
    public void execute(Long id) {
        productFacade.deleteProductEntityById(id);
    }
}
