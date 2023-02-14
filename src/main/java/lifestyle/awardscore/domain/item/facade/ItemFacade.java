package lifestyle.awardscore.domain.item.facade;

import lifestyle.awardscore.domain.item.entity.Item;
import lifestyle.awardscore.domain.item.entity.ItemDetail;
import lifestyle.awardscore.domain.item.exception.NotFoundItemException;
import lifestyle.awardscore.domain.item.repository.ItemDetailRepository;
import lifestyle.awardscore.domain.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemFacade {

    private final ItemRepository itemRepository;
    private final ItemDetailRepository itemDetailRepository;

    public Item findItemEntityById(Long id){
        return itemRepository.findById(id)
                .orElseThrow(() -> new NotFoundItemException("아이템이 존재하지 않습니다."));
    }

    public ItemDetail findItemDetailEntityById(Long id){
        return itemDetailRepository.findById(id)
                .orElseThrow(() -> new NotFoundItemException("아이템이 존재하지 않습니다."));
    }

    public void saveItemInfo(Item item, ItemDetail itemDetail){
        itemRepository.save(item);
        itemDetailRepository.save(itemDetail);
    }
}
