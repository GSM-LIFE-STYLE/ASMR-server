package lifestyle.awardscore.domain.order.entity;


import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.order.enum_type.OrderStatus;
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
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member host;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
