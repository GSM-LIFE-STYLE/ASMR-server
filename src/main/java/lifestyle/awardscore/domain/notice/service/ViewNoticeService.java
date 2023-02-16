package lifestyle.awardscore.domain.notice.service;

import lifestyle.awardscore.domain.notice.entity.Notice;
import lifestyle.awardscore.domain.notice.exception.NotFoundNoticeException;
import lifestyle.awardscore.domain.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ViewNoticeService {

    private final NoticeRepository noticeRepository;

    private void emptyNotice(List<Notice> notice) {
        if (notice.isEmpty()) {
            throw new NotFoundNoticeException("공지가 존재하지 않습니다.");
        }
    }

    public List<Notice> execute() {
        List<Notice> notice = noticeRepository.findAll();
        emptyNotice(notice);
        return notice;
    }
}
