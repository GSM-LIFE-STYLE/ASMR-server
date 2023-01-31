package lifestyle.awardscore.domain.item.entity;

import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_detail_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @Column(name = "content")
    private String content;
}
