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
public class RegisterMarketService {

    private final MemberFacade memberFacade;
    private final MarketFacade marketFacade;
    private final ConsumerFacade consumerFacade;

    @Transactional(rollbackFor = Exception.class)
    public Long execute(Long marketId){
        Member member = memberFacade.getCurrentMember();
        Market market = marketFacade.findMarketEntityById(marketId);

        memberFacade.verifyMemberQualification(member);
        memberFacade.verifyMemberAlreadyRegisteredMarket(member);
        Consumer consumer = consumerFacade.saveConsumer(Consumer.builder()
                .member(member)
                .market(market)
                .build());

        return consumer.getId();
    }

}
