package lifestyle.awardscore.domain.auth.repository;

import lifestyle.awardscore.domain.auth.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {
}
