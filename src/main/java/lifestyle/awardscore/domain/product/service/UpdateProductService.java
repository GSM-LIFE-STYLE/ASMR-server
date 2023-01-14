package lifestyle.awardscore.domain.product.service;

import lifestyle.awardscore.domain.product.entity.Product;
import lifestyle.awardscore.domain.product.facade.ProductFacade;
import lifestyle.awardscore.domain.product.presentation.dto.request.UpdateProductRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateProductService {

    private final ProductFacade productFacade;


    /**
     * 등록된 상품을 수정하는 서비스, 등록된 상품을 수정한다 null 값으로 인자가 넘어온 필드는
     * 수정을 하지 않고 원래의 값으로 유지한다.
     * @param id
     * @param request
     */
    @Transactional(rollbackFor = Exception.class)
    public void execute(Long id , UpdateProductRequest request) {
        Product product = productFacade.getProductEntityById(id);
        product.updateProduct(request.getProductName(), request.getPrice(), request.getDescription());
    }
}
