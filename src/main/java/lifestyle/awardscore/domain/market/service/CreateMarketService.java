package lifestyle.awardscore.domain.market.service;

import lifestyle.awardscore.domain.consumer.facade.ConsumerFacade;
import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.market.exception.AlreadyMarketOwnerException;
import lifestyle.awardscore.domain.market.exception.UnqualifiedMarketOwnerException;
import lifestyle.awardscore.domain.market.facade.MarketFacade;
import lifestyle.awardscore.domain.market.presentation.dto.request.CreateMarketRequest;
import lifestyle.awardscore.domain.market.repository.MarketRepository;
import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.member.facade.MemberFacade;
import lifestyle.awardscore.global.filter.role.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateMarketService {
    private final MemberFacade memberFacade;
    private final MarketFacade marketFacade;
    private final ConsumerFacade consumerFacade;


    @Transactional
    public Long execute(CreateMarketRequest request){
        Member currentMember = memberFacade.getCurrentMember();

        consumerFacade.existsByMember(currentMember);
        memberFacade.verifyTeacher(currentMember);

        Market market = marketFacade.saveMarket(Market.builder()
                .member(currentMember)
                .marketName(request.getMarketName())
                .build());

        return market.getId();

    }
}
