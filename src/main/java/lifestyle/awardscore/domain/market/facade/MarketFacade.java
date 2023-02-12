package lifestyle.awardscore.domain.market.facade;

import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.market.exception.NotFoundMarketException;
import lifestyle.awardscore.domain.market.repository.MarketRepository;
import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.member.facade.MemberFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MarketFacade {

    private final MarketRepository marketRepository;
    private final MemberFacade memberFacade;

    public Market getCurrentMarket(){
        return memberFacade.getCurrentMember().getMarket();
    }

    public Market findMarketEntityById(Long id){
        return marketRepository.findById(id)
                .orElseThrow(() -> new NotFoundMarketException("존재하지 않는 마켓입니다."));
    }

    public boolean verifyMemberIsMarketOwner(Member marketOwner){
        return marketOwner.equals(memberFacade.getCurrentMember());
    }
}
