package lifestyle.awardscore.domain.item.entity;

import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.order.entity.PayOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "preview_url")
    private String previewUrl;

    @ManyToOne
    @JoinColumn(name = "market_id")
    private Market market;

    @Column(name = "is_sold_out")
    boolean isSoldOut = false;

}
