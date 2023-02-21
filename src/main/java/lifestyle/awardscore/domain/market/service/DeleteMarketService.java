package lifestyle.awardscore.domain.market.service;

import lifestyle.awardscore.domain.item.entity.Item;
import lifestyle.awardscore.domain.item.facade.ItemFacade;
import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.market.facade.MarketFacade;
import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.member.facade.MemberFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeleteMarketService {

    private final MarketFacade marketFacade;
    private final MemberFacade memberFacade;
    private final ItemFacade itemFacade;

    @Transactional(rollbackFor = Exception.class)
    public void execute(Long marketId){
        Member currentMember = memberFacade.getCurrentMember();
        Market market = marketFacade.findMarketEntityById(marketId);
        List<Item> items = itemFacade.findAllItemByMarket(market);

        marketFacade.verifyMemberIsMarketOwner(currentMember);
        marketFacade.deleteMarket(market);
        itemFacade.deleteAllItems(items);
    }

}
