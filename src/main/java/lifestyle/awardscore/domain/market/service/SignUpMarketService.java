package lifestyle.awardscore.domain.market.service;

import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.market.facade.MarketFacade;
import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.member.facade.MemberFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignUpMarketService {

    private final MemberFacade memberFacade;
    private final MarketFacade marketFacade;

    @Transactional(rollbackFor = Exception.class)
    public void execute(Long marketId){
        Member currentMember = memberFacade.getCurrentMember();
        if (memberFacade.verifyMemberIsTeacher(currentMember))
            throw new Member


        Market market = marketFacade.findMarketEntityById(marketId);
        market.addMember(currentMember);
    }
}
