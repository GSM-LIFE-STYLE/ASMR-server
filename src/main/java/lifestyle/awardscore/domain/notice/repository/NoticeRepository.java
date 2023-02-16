package lifestyle.awardscore.domain.notice.repository;

import lifestyle.awardscore.domain.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
