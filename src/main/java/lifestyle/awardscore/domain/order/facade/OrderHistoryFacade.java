package lifestyle.awardscore.domain.order.facade;

import lifestyle.awardscore.domain.order.entity.OrderHistory;
import lifestyle.awardscore.domain.order.repository.OrderHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderHistoryFacade {

    private final OrderHistoryRepository orderHistoryRepository;

    public OrderHistory getOrderHistoryEntityById(Long id) {
        return orderHistoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(""))
    }
}
