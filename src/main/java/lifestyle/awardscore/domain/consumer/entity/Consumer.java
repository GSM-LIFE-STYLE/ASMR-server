package lifestyle.awardscore.domain.consumer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "market_id")
    private Market market;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

}
