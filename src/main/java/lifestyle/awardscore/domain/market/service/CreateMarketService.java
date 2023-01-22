package lifestyle.awardscore.domain.market.service;

import lifestyle.awardscore.domain.market.repository.MarketRepository;
import lifestyle.awardscore.domain.member.facade.MemberFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateMarketService {
    private final MemberFacade memberFacade;
    private final MarketRepository marketRepository;
}
