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

    /**
     * 등록된 모든 상점마켓을 전부 조회하는 서비스 로직
     * @return List<MarketResponse>
     * @author 김희망
     */
    public List<MarketResponse> execute(){
        return marketFacade.marketToDtoList(marketFacade.findAllMarkets());
    }
}
