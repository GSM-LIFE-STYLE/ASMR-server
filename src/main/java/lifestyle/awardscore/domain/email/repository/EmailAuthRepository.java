package lifestyle.awardscore.domain.email.repository;

import lifestyle.awardscore.domain.email.entity.EmailAuth;
import org.springframework.data.repository.CrudRepository;

public interface EmailAuthRepository extends CrudRepository<EmailAuth, String> {
}
