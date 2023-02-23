package lifestyle.awardscore.domain.market.service;

import lifestyle.awardscore.domain.item.entity.Item;
import lifestyle.awardscore.domain.item.facade.ItemFacade;
import lifestyle.awardscore.domain.item.presentation.dto.response.ItemResponse;
import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.market.facade.MarketFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LookUpMarketService {
    private final MarketFacade marketFacade;
    private final ItemFacade itemFacade;

    public List<ItemResponse> execute(Long marketId){
        Market market = marketFacade.findMarketEntityById(marketId);
        List<Item> items = itemFacade.findAllItemByMarket(market);
        return itemFacade.itemsToDtoList(items);
    }
}
