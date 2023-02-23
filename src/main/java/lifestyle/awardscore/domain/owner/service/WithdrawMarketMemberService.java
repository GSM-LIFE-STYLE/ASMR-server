package lifestyle.awardscore.domain.owner.service;

import lifestyle.awardscore.domain.consumer.entity.Consumer;
import lifestyle.awardscore.domain.consumer.facade.ConsumerFacade;
import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.market.facade.MarketFacade;
import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.member.facade.MemberFacade;
import lifestyle.awardscore.domain.owner.facade.OwnerFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WithdrawMarketMemberService {
    private final MemberFacade memberFacade;
    private final MarketFacade marketFacade;
    private final ConsumerFacade consumerFacade;
    private final OwnerFacade ownerFacade;

    @Transactional(rollbackFor = Exception.class)
    public void execute(Long memberId, Long marketId){
        Member currentMember = memberFacade.getCurrentMember();
        Market market = marketFacade.findMarketEntityById(marketId);
        Member withdrawMember = memberFacade.findById(memberId);
        Consumer consumer = consumerFacade.findByMember(withdrawMember);

        memberFacade.verifyTeacher(currentMember);
        marketFacade.verifyMemberIsMarketOwner(ownerFacade.findByMarket(market).getMember());
        consumerFacade.verifyMarketConsumer(consumer, market);

        consumerFacade.deleteByMarketAndMember(withdrawMember, market);
    }
}
