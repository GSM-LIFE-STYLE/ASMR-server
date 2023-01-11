package lifestyle.awardscore.domain.order.facade;

import lifestyle.awardscore.domain.order.entity.Order;
import lifestyle.awardscore.domain.order.exception.NotFoundOrderException;
import lifestyle.awardscore.domain.order.repository.OrderRepository;
import lifestyle.awardscore.domain.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderFacade {

    private final OrderRepository orderRepository;

    public Order getOrderEntityById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundOrderException("존재하지 않는 주문입니다."));
    }

    public Long getTotalPrice(List<Product> products) {
        long totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
