package lifestyle.awardscore.domain.market.service;

import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.market.facade.MarketFacade;
import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.member.facade.MemberFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateMarketNameService {
    private final MarketFacade marketFacade;
    private final MemberFacade memberFacade;

    public void execute(Long marketId){
        Member currentMember = memberFacade.getCurrentMember();
        Market market = marketFacade.findMarketEntityById(marketId);
        marketFacade.verifyMemberIsMarketOwner(currentMember);
    }
}
