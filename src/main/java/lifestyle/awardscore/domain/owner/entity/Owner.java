package lifestyle.awardscore.domain.owner.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.member.entity.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "market_id")
    private Market market;
}
