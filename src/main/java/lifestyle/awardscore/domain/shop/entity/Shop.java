package lifestyle.awardscore.domain.shop.entity;

import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.order.entity.Order;
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
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shop_id", nullable = false)
    private Long shopId;

    @OneToOne(mappedBy = "shop")
    private Member member;

    @OneToMany(mappedBy = "shop")
    private List<Product> products;

}
