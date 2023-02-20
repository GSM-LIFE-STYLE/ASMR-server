package lifestyle.awardscore.domain.item.repository;

import lifestyle.awardscore.domain.item.entity.Item;
import lifestyle.awardscore.domain.market.entity.Market;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item,Long> {
    List<Item> findAllByMarket(Market market);
}
