package lifestyle.awardscore.domain.member.repository;

import lifestyle.awardscore.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
