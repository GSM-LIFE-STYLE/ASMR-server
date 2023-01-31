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

    @Column(name = "content")
    private String content;
}
