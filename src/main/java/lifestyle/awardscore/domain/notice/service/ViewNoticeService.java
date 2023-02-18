package lifestyle.awardscore.domain.notice.service;

import lifestyle.awardscore.domain.notice.entity.Notice;
import lifestyle.awardscore.domain.notice.presentation.dto.response.ViewNoticeResponse;
import lifestyle.awardscore.domain.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ViewNoticeService {

    private final NoticeRepository noticeRepository;

    public List<ViewNoticeResponse> execute() {
        List<Notice> noticeList = noticeRepository.findAll();
        List<ViewNoticeResponse> response = noticeList.stream()
                .map(n -> new ViewNoticeResponse(n.getTitle(), n.getContent()))
                .collect(Collectors.toList());
        return response;
    }

}
