package lifestyle.awardscore.domain.member.facade;

import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.member.exception.MemberNotFoundException;
import lifestyle.awardscore.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberFacade {

    private final MemberRepository memberRepository;

    public Member getCurrentMember() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return memberRepository.findByEmail(email)
                .orElseThrow(() -> new MemberNotFoundException("존재하지 않는 회원입니다."));
    }

}
