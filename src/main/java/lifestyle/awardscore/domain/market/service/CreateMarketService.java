package lifestyle.awardscore.domain.market.service;

import lifestyle.awardscore.domain.consumer.entity.Consumer;
import lifestyle.awardscore.domain.consumer.facade.ConsumerFacade;
import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.market.exception.AlreadyMarketOwnerException;
import lifestyle.awardscore.domain.market.exception.UnqualifiedMarketOwnerException;
import lifestyle.awardscore.domain.market.facade.MarketFacade;
import lifestyle.awardscore.domain.market.presentation.dto.request.CreateMarketRequest;
import lifestyle.awardscore.domain.market.repository.MarketRepository;
import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.member.facade.MemberFacade;
import lifestyle.awardscore.domain.owner.entity.Owner;
import lifestyle.awardscore.domain.owner.facade.OwnerFacade;
import lifestyle.awardscore.global.filter.role.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateMarketService {
    private final MemberFacade memberFacade;
    private final MarketFacade marketFacade;
    private final OwnerFacade ownerFacade;


    @Transactional
    public Long execute(CreateMarketRequest request){
        Member currentMember = memberFacade.getCurrentMember();

        ownerFacade.existsByMember(currentMember);
        memberFacade.verifyTeacher(currentMember);

        Market market = marketFacade.saveMarket(Market.builder()
                .marketName(request.getMarketName())
                .build());

        ownerFacade.saveOwner(Owner.builder()
                .member(currentMember)
                .market(market)
                .build());

        return market.getId();
    }
}
