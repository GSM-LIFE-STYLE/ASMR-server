package lifestyle.awardscore.domain.owner.repository;

import lifestyle.awardscore.domain.owner.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
