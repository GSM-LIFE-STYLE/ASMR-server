package lifestyle.awardscore.domain.order.entity;

import lifestyle.awardscore.domain.item.entity.Item;
import lifestyle.awardscore.domain.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PayOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pay_order_id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "id")
    private List<Item> item;

    @OneToOne
    private Member member;

    @Column(name = "count")
    private Long count;

    @Column(name = "price")
    private Long price;

}
