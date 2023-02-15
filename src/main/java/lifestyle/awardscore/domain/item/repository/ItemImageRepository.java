package lifestyle.awardscore.domain.item.repository;

import lifestyle.awardscore.domain.item.entity.ItemImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemImageRepository extends JpaRepository<ItemImage, Long> {
    List<ItemImage> findItemImageByItemId(Long itemId);
}
