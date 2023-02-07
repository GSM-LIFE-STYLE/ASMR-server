package lifestyle.awardscore.domain.auth.repository;

import lifestyle.awardscore.domain.auth.entity.BlackList;
import org.springframework.data.repository.CrudRepository;

public interface BlackListRepository extends CrudRepository<BlackList, String> {
}
