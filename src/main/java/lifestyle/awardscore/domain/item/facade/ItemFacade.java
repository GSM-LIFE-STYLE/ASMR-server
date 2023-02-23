package lifestyle.awardscore.domain.item.facade;

import lifestyle.awardscore.domain.item.entity.Item;
import lifestyle.awardscore.domain.item.entity.ItemImage;
import lifestyle.awardscore.domain.item.exception.ForbiddenAccessItemException;
import lifestyle.awardscore.domain.item.exception.NotFoundItemException;
import lifestyle.awardscore.domain.item.presentation.dto.response.ItemResponse;
import lifestyle.awardscore.domain.item.repository.ItemImageRepository;
import lifestyle.awardscore.domain.item.repository.ItemRepository;
import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.market.facade.MarketFacade;
import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.member.facade.MemberFacade;
import lifestyle.awardscore.domain.owner.facade.OwnerFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ItemFacade {

    private final ItemRepository itemRepository;
    private final ItemImageRepository itemImageRepository;
    private final MemberFacade memberFacade;
    private final OwnerFacade ownerFacade;
    private final MarketFacade marketFacade;

    public Item findItemEntityById(Long id){
        return itemRepository.findById(id)
                .orElseThrow(() -> new NotFoundItemException("아이템이 존재하지 않습니다."));
    }

    public ItemImage findItemImageEntityByItemId(Long id){
        return itemImageRepository.findById(id)
                .orElseThrow(() -> new NotFoundItemException("아이템이 존재하지 않습니다."));
    }

    public List<Item> findAllItemByMarket(Market market){
        return itemRepository.findAllByMarket(market);
    }

    public void saveItemInfo(Item item, ItemImage itemImage){
        itemRepository.save(item);
        itemImageRepository.save(itemImage);
    }

    public List<String> findItemImageByItemId(Long itemId){
        return itemImageRepository.findItemImageByItemId(itemId)
                .stream().map(ItemImage::getPreviewUrl).collect(Collectors.toList());
    }

    public List<ItemResponse> itemsToDtoList(List<Item> items){
        return items.stream().map(i -> ItemResponse.builder()
                .itemId(i.getId())
                .title(i.getTitle())
                .price(i.getPrice())
                .previewUrl(findItemImageEntityByItemId(i.getId()).getPreviewUrl())
                .build()).collect(Collectors.toList());
    }

    public void deleteAllItems(List<Item> items){
        itemRepository.deleteAll(items);
    }

    public void verifyMemberAndMarket(Member currentMember, Market market){
        if(!memberFacade.verifyMemberIsTeacher(currentMember))
            throw new ForbiddenAccessItemException("아이템의 정보에 접근할 수 있는 권한이 없습니다.");

        if(!marketFacade.verifyMemberIsMarketOwner(ownerFacade.findByMarket(market).getMember()))
            throw new ForbiddenAccessItemException("아이템의 정보에 접근할 수 있는 권한이 없습니다.");

    }
}
