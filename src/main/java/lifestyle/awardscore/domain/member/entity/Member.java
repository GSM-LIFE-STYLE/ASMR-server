package lifestyle.awardscore.domain.member.entity;

import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.order.entity.Orders;
import lifestyle.awardscore.global.filter.role.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity @Table(name = "member")
@Getter @Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "email" , nullable = false , length = 40)
    private String email;

    @Column(name = "password" , nullable = false , length = 25)
    private String password;

    @Column(name = "student_name" , nullable = false, length = 10)
    private String studentName;

    @Column(name = "student_number" , nullable = false , unique = true , length = 4)
    private String studentNumber;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "market_id")
    private Market market;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Orders> orders;

    public void updateMarket(Market market) {
        this.market = market;
    }
}
