package lifestyle.awardscore.domain.shop.entity;

import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.mail.FetchProfile;
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

    @OneToOne(mappedBy = "memberId")
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<Product> products;
}
