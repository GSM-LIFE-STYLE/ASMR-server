package lifestyle.awardscore.domain.market.service;

import lifestyle.awardscore.domain.consumer.facade.ConsumerFacade;
import lifestyle.awardscore.domain.item.entity.Item;
import lifestyle.awardscore.domain.item.facade.ItemFacade;
import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.market.facade.MarketFacade;
import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.member.facade.MemberFacade;
import lifestyle.awardscore.domain.owner.facade.OwnerFacade;
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
    private final ConsumerFacade consumerFacade;
    private final OwnerFacade ownerFacade;

    /**
     * 자신이 등록한 상점마켓을 삭제하는 서비스 로직
     * @param marketId
     * @author 김희망
     */
    @Transactional(rollbackFor = Exception.class)
    public void execute(Long marketId){
        Member currentMember = memberFacade.getCurrentMember();
        Market market = marketFacade.findMarketEntityById(marketId);
        List<Item> items = itemFacade.findAllItemByMarket(market);

        marketFacade.verifyMemberIsMarketOwner(currentMember);

        consumerFacade.deleteAllByMarket(market);
        ownerFacade.deleteByMarket(market);
        marketFacade.deleteMarket(market);
        itemFacade.deleteAllItems(items);
    }

}
