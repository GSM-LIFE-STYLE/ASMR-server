package lifestyle.awardscore.domain.notice.service;

import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.member.facade.MemberFacade;
import lifestyle.awardscore.domain.notice.entity.Notice;
import lifestyle.awardscore.domain.notice.presentation.dto.request.WriteNoticeRequest;
import lifestyle.awardscore.domain.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WriteNoticeService {

    private final NoticeRepository noticeRepository;
    private final MemberFacade memberFacade;


    @Transactional
    public void execute(WriteNoticeRequest request) {

        Member currentMember = memberFacade.getCurrentMember();

        Notice notice = Notice.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .member(currentMember).build();

        noticeRepository.save(notice);
    }
}
