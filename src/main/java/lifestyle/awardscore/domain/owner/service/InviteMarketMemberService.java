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
public class InviteMarketMemberService {

    private final OwnerFacade ownerFacade;
    private final MemberFacade memberFacade;
    private final MarketFacade marketFacade;
    private final ConsumerFacade consumerFacade;

    @Transactional(rollbackFor = Exception.class)
    public Long execute(Long marketId, Long memberId){
        Member currentMember = memberFacade.getCurrentMember();
        Market market = marketFacade.findMarketEntityById(marketId);
        Member invitedMember = memberFacade.findById(memberId);

        memberFacade.verifyTeacher(currentMember);
        marketFacade.verifyMemberIsMarketOwner(ownerFacade.findByMarket(market).getMember());
        memberFacade.verifyMemberAlreadyRegisteredMarket(invitedMember);

        Consumer consumer = consumerFacade.saveConsumer(Consumer.builder()
                .member(invitedMember)
                .market(market)
                .build());

        return consumer.getId();
    }

}
