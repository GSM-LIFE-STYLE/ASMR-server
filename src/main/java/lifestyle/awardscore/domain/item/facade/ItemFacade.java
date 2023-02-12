package lifestyle.awardscore.domain.item.facade;

import lifestyle.awardscore.domain.item.entity.Item;
import lifestyle.awardscore.domain.item.exception.NotFoundItemException;
import lifestyle.awardscore.domain.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemFacade {

    private final ItemRepository itemRepository;

    public Item findItemEntityById(Long id){
        return itemRepository.findById(id)
                .orElseThrow(() -> new NotFoundItemException("아이템이 존재하지 않습니다."));
    }
}
