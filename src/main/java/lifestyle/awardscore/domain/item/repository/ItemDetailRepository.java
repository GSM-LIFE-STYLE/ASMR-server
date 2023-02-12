package lifestyle.awardscore.domain.item.repository;

import lifestyle.awardscore.domain.item.entity.ItemDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDetailRepository extends JpaRepository<ItemDetail, Long> {
}
