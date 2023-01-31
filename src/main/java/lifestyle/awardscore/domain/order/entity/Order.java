package lifestyle.awardscore.domain.order.entity;


import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.order.enum_type.OrderStatus;
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
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id", nullable = false)
    private Long id;


    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

}
