package lifestyle.awardscore.domain.consumer.repository;

import lifestyle.awardscore.domain.consumer.entity.Consumer;
import lifestyle.awardscore.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumerRepository extends JpaRepository<Consumer, Long> {
    boolean existsByMember(Member member);
}
