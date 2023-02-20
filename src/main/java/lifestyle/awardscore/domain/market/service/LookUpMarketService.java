package lifestyle.awardscore.domain.market.service;

import lifestyle.awardscore.domain.market.facade.MarketFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LookUpMarketService {
    private final MarketFacade marketFacade;

}
