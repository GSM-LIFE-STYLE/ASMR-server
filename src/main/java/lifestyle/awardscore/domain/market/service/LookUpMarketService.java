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

    /**
     * 상점 마켓 정보를 상세하게 조회하는 서비스 로직
     * 상점마켓에 등록된 아이템 리스트를 불러온다.
     * @param marketId
     * @return itemList
     * @author 김희망
     */
    public List<ItemResponse> execute(Long marketId){
        Market market = marketFacade.findMarketEntityById(marketId);
        List<Item> items = itemFacade.findAllItemByMarket(market);
        return itemFacade.itemsToDtoList(items);
    }
}
