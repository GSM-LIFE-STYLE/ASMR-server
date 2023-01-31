package lifestyle.awardscore.domain.item.entity;

import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.member.entity.Member;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id", nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "preview_url")
    private String previewUrl;



    @Column(name = "is_sold_out")
    boolean isSoldOut = false;
}
