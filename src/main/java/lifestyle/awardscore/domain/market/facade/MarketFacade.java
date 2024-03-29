package lifestyle.awardscore.domain.market.facade;

import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.market.exception.NotFoundMarketException;
import lifestyle.awardscore.domain.market.presentation.dto.response.MarketResponse;
import lifestyle.awardscore.domain.market.repository.MarketRepository;
import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.member.facade.MemberFacade;
import lifestyle.awardscore.domain.owner.entity.Owner;
import lifestyle.awardscore.domain.owner.facade.OwnerFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerTemplateAvailabilityProvider;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MarketFacade {

    private final MarketRepository marketRepository;
    private final MemberFacade memberFacade;
    private final OwnerFacade ownerFacade;


    public Market findMarketEntityById(Long id){
        return marketRepository.findById(id)
                .orElseThrow(() -> new NotFoundMarketException("존재하지 않는 마켓입니다."));
    }


    public void deleteMarket(Market market){
        marketRepository.delete(market);
    }

    public List<Market> findAllMarkets(){
        return marketRepository.findAll();
    }

    public boolean verifyMemberIsMarketOwner(Member marketOwner){
        return marketOwner.equals(memberFacade.getCurrentMember());
    }

    public MarketResponse marketToDto(Market market){
        return MarketResponse.builder()
                .marketId(market.getId())
                .marketName(market.getMarketName())
                .marketOwnerName(ownerFacade.findByMarket(market).getMember().getName())
                .build();
    }

    public List<MarketResponse> marketToDtoList(List<Market> markets){
        return markets.stream().map(m -> marketToDto(m)).collect(Collectors.toList());
    }

    public Market saveMarket(Market market){
        return marketRepository.save(market);
    }


}
