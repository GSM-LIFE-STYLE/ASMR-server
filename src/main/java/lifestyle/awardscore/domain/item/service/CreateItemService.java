package lifestyle.awardscore.domain.item.service;

import lifestyle.awardscore.domain.item.entity.Item;
import lifestyle.awardscore.domain.item.entity.ItemImage;
import lifestyle.awardscore.domain.item.exception.ForbiddenAccessItemException;
import lifestyle.awardscore.domain.item.facade.ItemFacade;
import lifestyle.awardscore.domain.item.presentation.dto.request.CreateItemRequest;
import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.market.facade.MarketFacade;
import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.member.facade.MemberFacade;
import lifestyle.awardscore.domain.owner.facade.OwnerFacade;
import lifestyle.awardscore.infrastructure.s3.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class CreateItemService {

    private final ItemFacade itemFacade;
    private final MemberFacade memberFacade;
    private final MarketFacade marketFacade;
    private final OwnerFacade ownerFacade;
    private final S3Service s3Service;



    private ItemImage saveToUrl(Item item, String title, String uploadFileUrl) {
        return ItemImage.builder()
                .item(item)
                .previewUrl("https://awardscore.s3.ap-northeast-2.amazonaws.com/MARKET/"+ title + "/" + uploadFileUrl)
                .build();
    }

    @Transactional(rollbackFor = Exception.class)
    public Long execute(Long marketId, CreateItemRequest request, MultipartFile multipartFile){
        Member currentMember = memberFacade.getCurrentMember();
        Market findMarket = marketFacade.findMarketEntityById(marketId);

        itemFacade.verifyMemberAndMarket(currentMember,findMarket);

        Item item = Item.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .market(findMarket)
                .price(request.getPrice())
                .isSoldOut(false)
                .build();

        String uploadFileUrl = s3Service.uploadFile(multipartFile, "ITEM/" + item.getTitle() + "/USER/" + currentMember.getId() +"/");
        itemFacade.saveItemInfo(item, saveToUrl(item, item.getTitle(), uploadFileUrl));

        return item.getId();
    }
}
