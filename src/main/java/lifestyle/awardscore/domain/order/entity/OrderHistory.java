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
public class OrderHistory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_history_id", nullable = false)
    private Long orderHistoryId;
    
    @OneToOne(mappedBy = "orderHistory")
    private Member member;

    @OneToOne(mappedBy = "orderHistory")
    private Order order;

    @OneToMany(mappedBy = "orderHistory")
    private List<Product> products;

    @Column(name = "order_status")
    private boolean orderStatus = false;

    public void updateStatus() {
        this.orderStatus = true;
    }

}
