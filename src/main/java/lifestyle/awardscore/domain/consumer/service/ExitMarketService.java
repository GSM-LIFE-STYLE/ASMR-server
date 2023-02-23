package lifestyle.awardscore.domain.consumer.service;

import lifestyle.awardscore.domain.consumer.entity.Consumer;
import lifestyle.awardscore.domain.consumer.facade.ConsumerFacade;
import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.market.facade.MarketFacade;
import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.member.facade.MemberFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExitMarketService {
    private final MarketFacade marketFacade;
    private final MemberFacade memberFacade;
    private final ConsumerFacade consumerFacade;

    @Transactional(rollbackFor = Exception.class)
    public void execute(Long marketId){
        Member currentMember = memberFacade.getCurrentMember();
        Market market = marketFacade.findMarketEntityById(marketId);
        Consumer consumer = consumerFacade.findByMember(currentMember);

        memberFacade.verifyMemberQualification(currentMember);
        consumerFacade.verifyMarketConsumer(consumer, market);

        consumerFacade.deleteByMarketAndMember(currentMember, market);
    }
}
