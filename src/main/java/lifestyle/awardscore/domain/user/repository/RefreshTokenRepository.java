package lifestyle.awardscore.domain.user.repository;

import lifestyle.awardscore.domain.user.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {
}
