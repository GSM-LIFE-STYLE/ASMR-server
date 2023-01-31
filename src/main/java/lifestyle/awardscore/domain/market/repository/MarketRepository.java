package lifestyle.awardscore.domain.market.repository;

import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarketRepository extends JpaRepository<Market, Long> {
    boolean existsByMember(Member member);
}
