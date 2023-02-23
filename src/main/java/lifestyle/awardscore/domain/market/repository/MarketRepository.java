package lifestyle.awardscore.domain.market.repository;

import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface MarketRepository extends JpaRepository<Market, Long> {
    boolean existsByMember(Member member);
    Optional<Market> findByMember(Member member);
}
