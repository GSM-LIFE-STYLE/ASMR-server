package lifestyle.awardscore.domain.notice.service;

import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.member.facade.MemberFacade;
import lifestyle.awardscore.domain.notice.entity.Notice;
import lifestyle.awardscore.domain.notice.exception.UnqualifiedNoticeWriterException;
import lifestyle.awardscore.domain.notice.presentation.dto.request.WriteNoticeRequest;
import lifestyle.awardscore.domain.notice.repository.NoticeRepository;
import lifestyle.awardscore.global.filter.role.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WriteNoticeService {

    private final NoticeRepository noticeRepository;
    private final MemberFacade memberFacade;


    private void verifyMember(Member member) {
        if (member.getRole() == Role.STUDENT) {
            throw new UnqualifiedNoticeWriterException("공지글을 작성할 권한이 없습니다.");
        }
    }

    /**
     * 어드민, 선생님이 직접 공지사항을 작성하는 서비스 로직
     * @param request (title, content)
     * @author 박주홍
     */
    @Transactional
    public void execute(WriteNoticeRequest request) {

        Member currentMember = memberFacade.getCurrentMember();
        verifyMember(currentMember);

        Notice notice = Notice.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .member(currentMember)
                .build();

        noticeRepository.save(notice);
    }
}
