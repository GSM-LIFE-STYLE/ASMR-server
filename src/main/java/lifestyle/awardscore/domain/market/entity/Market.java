package lifestyle.awardscore.domain.market.entity;

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
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "market_id", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(name = "market_name")
    private String marketName;

    @OneToMany(mappedBy = "id")
    private List<Item> items;
}
