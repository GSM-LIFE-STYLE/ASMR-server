package lifestyle.awardscore.domain.consumer.entity;

import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.member.entity.Member;
import lombok.*;
import org.yaml.snakeyaml.error.Mark;

import javax.persistence.*;
import java.lang.management.MemoryMXBean;

@Entity
@Getter @Builder
@AllArgsConstructor
@NoArgsConstructor
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "market_id")
    private Market market;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

}
