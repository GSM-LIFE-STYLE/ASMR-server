package lifestyle.awardscore.domain.market.repository;

import lifestyle.awardscore.domain.market.entity.Market;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<Market, Long> {
}
