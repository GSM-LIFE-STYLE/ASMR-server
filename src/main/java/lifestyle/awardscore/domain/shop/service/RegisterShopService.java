package lifestyle.awardscore.domain.shop.service;

import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.member.facade.MemberFacade;
import lifestyle.awardscore.domain.shop.entity.Shop;
import lifestyle.awardscore.domain.shop.facade.ShopFacade;
import lifestyle.awardscore.domain.shop.presentation.dto.RegisterShopRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterShopService {

    private final ShopFacade shopFacade;
    private final MemberFacade memberFacade;

    /**
     * 상점마켓을 등록하는 서비스
     * 상점마켓을 등록한 후에 아이템을 등록할 수 있으므로 products 를 null 로 설정해주었다.
     * @param request
     */
    @Transactional(rollbackFor = Exception.class)
    public void execute(RegisterShopRequest request){
        Member currentMember = memberFacade.getCurrentMember();
        shopFacade.saveShopEntity(Shop.builder()
                .member(currentMember)
                .products(null)
                .shopName(request.getShopName())
                .build());
    }
}
