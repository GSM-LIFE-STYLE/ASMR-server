package lifestyle.awardscore.domain.owner.repository;

import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.owner.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    boolean existsByMember(Member member);
    void deleteAllByMemberAndMarket(Member member, Market market);
    void deleteAllByMarket(Market market);
    Optional<Owner> findByMarket(Market market);
}
