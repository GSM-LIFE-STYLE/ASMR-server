package lifestyle.awardscore.domain.market.service;

import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.market.exception.AlreadyMarketOwnerException;
import lifestyle.awardscore.domain.market.presentation.dto.request.CreateMarketRequest;
import lifestyle.awardscore.domain.market.repository.MarketRepository;
import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.member.facade.MemberFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateMarketService {
    private final MemberFacade memberFacade;
    private final MarketRepository marketRepository;

    private void verifyMarketOwner(Member member) {
        if(marketRepository.existsByMember(member))
            throw new AlreadyMarketOwnerException("이미 마켓을 등록한 멤버입니다.");
    }

    @Transactional
    public void execute(CreateMarketRequest request){
        Member currentMember = memberFacade.getCurrentMember();

        verifyMarketOwner(currentMember);

        Market market = marketRepository.save(Market.builder()
                .member(currentMember)
                .marketName(request.getMarketName())
                .build());

        currentMember.updateMarket(market);
    }
}
