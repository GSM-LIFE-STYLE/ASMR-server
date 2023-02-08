package lifestyle.awardscore.domain.market.service;

import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.market.exception.AlreadyMarketOwnerException;
import lifestyle.awardscore.domain.market.exception.UnqualifiedMarketOwnerException;
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
    private final MarketRepository marketRepository;

    private void verifyMarketOwner(Member member) {
        if(marketRepository.existsByMember(member))
            throw new AlreadyMarketOwnerException("이미 마켓을 등록한 멤버입니다.");

        if(member.getRole() != Role.TEACHER) {
            throw new UnqualifiedMarketOwnerException("상점 주인이 될 자격이 없는 멤버입니다.");
        }
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
