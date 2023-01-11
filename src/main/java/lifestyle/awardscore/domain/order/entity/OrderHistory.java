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
    
    @OneToOne(mappedBy = "memberId")
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(mappedBy = "orderId")
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToMany(mappedBy = "productId")
    @JoinColumn(name = "product_id")
    private List<Product> products;

    @Column(name = "orderStatus")
    private boolean orderStatus = false;

    public void updateStatus() {
        this.orderStatus = true;
    }

}
