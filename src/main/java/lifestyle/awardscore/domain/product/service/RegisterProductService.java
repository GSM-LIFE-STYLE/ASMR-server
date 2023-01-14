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

    /**
     * 상품을 등록하는 서비스, 상품의 이름 가격 설명을 받은 DTO 로 상품을 등록한다.
     * @param request
     */
    @Transactional(rollbackFor = Exception.class)
    public void execute(RegisterProductRequest request) {
        productFacade.saveProductEntity(request.toEntity());
    }

}
