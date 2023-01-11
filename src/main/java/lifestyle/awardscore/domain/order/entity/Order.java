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

    @OneToOne(mappedBy = "memberId")
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "productId")
    @JoinColumn(name = "product_id")
    private List<Product> orderProducts;

    @Column(name = "total_price")
    private Long total_price;

}
