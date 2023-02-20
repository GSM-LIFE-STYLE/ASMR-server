package lifestyle.awardscore.domain.item.facade;

import lifestyle.awardscore.domain.item.entity.Item;
import lifestyle.awardscore.domain.item.entity.ItemImage;
import lifestyle.awardscore.domain.item.exception.NotFoundItemException;
import lifestyle.awardscore.domain.item.presentation.dto.response.ItemResponse;
import lifestyle.awardscore.domain.item.repository.ItemImageRepository;
import lifestyle.awardscore.domain.item.repository.ItemRepository;
import lifestyle.awardscore.domain.market.entity.Market;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.error.Mark;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ItemFacade {

    private final ItemRepository itemRepository;
    private final ItemImageRepository itemImageRepository;

    public Item findItemEntityById(Long id){
        return itemRepository.findById(id)
                .orElseThrow(() -> new NotFoundItemException("아이템이 존재하지 않습니다."));
    }

    public ItemImage findItemDetailEntityById(Long id){
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
                .build()).collect(Collectors.toList());
    }
}
