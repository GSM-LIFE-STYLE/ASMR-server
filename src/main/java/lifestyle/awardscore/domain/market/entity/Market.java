package lifestyle.awardscore.domain.market.entity;

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

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "market", fetch = FetchType.LAZY)
    private List<Member> members;

    @Column(name = "market_name")
    private String marketName;
}
