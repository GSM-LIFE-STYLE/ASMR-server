package lifestyle.awardscore.domain.order.repository;

import lifestyle.awardscore.domain.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order , Long> {
}
