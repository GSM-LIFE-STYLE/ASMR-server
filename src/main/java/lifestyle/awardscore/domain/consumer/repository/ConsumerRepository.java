package lifestyle.awardscore.domain.consumer.repository;

import lifestyle.awardscore.domain.consumer.entity.Consumer;
import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.error.Mark;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface ConsumerRepository extends JpaRepository<Consumer, Long> {
    boolean existsByMember(Member member);
    boolean existsByMemberAndMarket(Member member, Market market);
    Optional<Consumer> findByMemberAndMarket(Member member, Market market);
    void deleteAllByMarket(Market market);
    Optional<Consumer> findByMember(Member member);
    void deleteByMemberAndMarket(Member member, Market market);
}
