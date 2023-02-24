package lifestyle.awardscore.domain.notice.service;

import lifestyle.awardscore.domain.notice.entity.Notice;
import lifestyle.awardscore.domain.notice.presentation.dto.response.ViewNoticeResponse;
import lifestyle.awardscore.domain.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ViewNoticeService {

    private final NoticeRepository noticeRepository;

    /**
     * 등록된 공지사항 전체를 조회하는 서비스 로직
     * @return notices
     * @author 박주홍
     */
    public List<ViewNoticeResponse> execute() {
        List<Notice> noticeList = noticeRepository.findAll();
        return noticeList.stream()
                .map(n -> ViewNoticeResponse.builder()
                        .id(n.getNoticeId()).title(n.getTitle()).content(n.getContent()).build())
                .collect(Collectors.toList());
    }

}
