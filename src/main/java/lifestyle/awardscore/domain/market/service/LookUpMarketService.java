package lifestyle.awardscore.domain.market.service;

import lifestyle.awardscore.domain.item.presentation.dto.response.ItemResponse;
import lifestyle.awardscore.domain.market.facade.MarketFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LookUpMarketService {
    private final MarketFacade marketFacade;

    public List<ItemResponse> execute(){
        return null;
    }
}
