package lifestyle.awardscore.domain.order.entity;

import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @OneToOne(mappedBy = "order")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<Product> products;

    @Column(name = "total_price")
    private Long totalPrice;

    @OneToOne
    @JoinColumn(name = "order_history_id")
    private OrderHistory orderHistory;

}
