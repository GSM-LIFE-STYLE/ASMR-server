package lifestyle.awardscore.domain.shop.repository;

import lifestyle.awardscore.domain.shop.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop , Long> {
}
