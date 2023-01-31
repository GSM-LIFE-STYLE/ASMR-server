package lifestyle.awardscore.domain.member.entity;

import lifestyle.awardscore.global.filter.role.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
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

}
