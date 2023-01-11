package lifestyle.awardscore.domain.order.repository;

import lifestyle.awardscore.domain.order.entity.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory , Long> {
}
