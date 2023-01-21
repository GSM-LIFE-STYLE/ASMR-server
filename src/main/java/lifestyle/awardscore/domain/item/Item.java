package lifestyle.awardscore.domain.item;

import lifestyle.awardscore.domain.market.Market;
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
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "market_id")
    private Market market;

    @Column(name = "title")
    private String title;

    @Column(name = "preview_url")
    private String previewUrl;

    @Column(name = "is_sold_out")
    boolean isSoldOud = false;
}
