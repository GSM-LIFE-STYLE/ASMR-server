package lifestyle.awardscore.domain.product.service;

import lifestyle.awardscore.domain.product.facade.ProductFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteProductService {

    private final ProductFacade productFacade;

    /**
     * 등록된 아이템을 삭제하는 서비스, pk 값을 받아 제거를 한다.
     * @param id
     */

    @Transactional(rollbackFor = Exception.class)
    public void execute(Long id) {
        productFacade.deleteProductEntityById(id);
    }
}
