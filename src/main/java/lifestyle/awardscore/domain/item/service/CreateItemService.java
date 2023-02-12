package lifestyle.awardscore.domain.item.service;

import lifestyle.awardscore.domain.item.exception.ForbiddenAccessItemException;
import lifestyle.awardscore.domain.item.facade.ItemFacade;
import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.market.facade.MarketFacade;
import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.member.facade.MemberFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateItemService {

    private final ItemFacade itemFacade;
    private final MemberFacade memberFacade;
    private final MarketFacade marketFacade;

    private void verifyMemberAndMarket(Member currentMember, Market market){
        if(!memberFacade.verifyMemberIsTeacher(currentMember))
            throw new ForbiddenAccessItemException("아이템의 정보에 접근할 수 있는 권한이 없습니다.");

        if(!marketFacade.verifyMemberIsMarketOwner(market.getMember()))
            throw new ForbiddenAccessItemException("아이템의 정보에 접근할 수 있는 권한이 없습니다.");

    }

    @Transactional(rollbackFor = Exception.class)
    public void execute(Long marketId){
        Member currentMember = memberFacade.getCurrentMember();
        Market findMarket = marketFacade.findMarketEntityById(marketId);

        verifyMemberAndMarket(currentMember,findMarket);


    }
}
