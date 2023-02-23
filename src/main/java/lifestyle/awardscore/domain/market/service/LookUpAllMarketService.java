package lifestyle.awardscore.domain.market.service;

import lifestyle.awardscore.domain.item.facade.ItemFacade;
import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.market.facade.MarketFacade;
import lifestyle.awardscore.domain.market.presentation.dto.response.MarketResponse;
import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.member.facade.MemberFacade;
import lifestyle.awardscore.domain.owner.entity.Owner;
import lifestyle.awardscore.domain.owner.facade.OwnerFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LookUpAllMarketService {
    private final MarketFacade marketFacade;
    private final OwnerFacade ownerFacade;
    private final MemberFacade memberFacade;

    public List<MarketResponse> execute(){
        Member currentMember = memberFacade.getCurrentMember();
        Market market = marketFacade.findByMember(currentMember);
        Owner owner = ownerFacade.findByMarket(market);

        return marketFacade.marketToDtoList(marketFacade.findAllMarkets(), owner);
    }
}
