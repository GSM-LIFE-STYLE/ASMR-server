package lifestyle.awardscore.domain.consumer.service;

import lifestyle.awardscore.domain.market.facade.MarketFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExitMarketService {
    private final MarketFacade marketFacade;

    @Transactional(rollbackFor = Exception.class)
    public void execute(Long marketId){

    }
}
