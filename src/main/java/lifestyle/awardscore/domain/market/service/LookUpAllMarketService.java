package lifestyle.awardscore.domain.market.service;

import lifestyle.awardscore.domain.market.facade.MarketFacade;
import lifestyle.awardscore.domain.market.presentation.dto.response.MarketResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LookUpAllMarketService {
    private final MarketFacade marketFacade;

    public List<MarketResponse> execute(){
        List<MarketResponse> responses = marketFacade
                .marketToDtoList(marketFacade.findAllMarkets());
        return responses;
    }
}
