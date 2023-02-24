package lifestyle.awardscore.domain.market.service;

import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.market.facade.MarketFacade;
import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.member.facade.MemberFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateMarketNameService {
    private final MarketFacade marketFacade;
    private final MemberFacade memberFacade;

    /**
     * 자신의 상점마켓 정보를 변경하는 서비스 로직 (사실 마켓 이름 변경서비스)
     * @param marketId
     * @param newMarketName
     * @author 김희망
     */
    @Transactional(rollbackFor = Exception.class)
    public void execute(Long marketId, String newMarketName){
        Member currentMember = memberFacade.getCurrentMember();
        Market market = marketFacade.findMarketEntityById(marketId);
        marketFacade.verifyMemberIsMarketOwner(currentMember);
        market.updateMarketName(newMarketName);
    }
}
