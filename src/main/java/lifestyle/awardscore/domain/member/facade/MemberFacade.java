package lifestyle.awardscore.domain.member.facade;

import lifestyle.awardscore.domain.auth.exception.PasswordMismatchException;
import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.market.exception.AlreadyRegisterMarketException;
import lifestyle.awardscore.domain.market.exception.UnqualifiedMarketMemberException;
import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.member.exception.MemberNotFoundException;
import lifestyle.awardscore.domain.member.repository.MemberRepository;
import lifestyle.awardscore.global.filter.role.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class MemberFacade {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member getCurrentMember() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return memberRepository.findByEmail(email)
                .orElseThrow(() -> new MemberNotFoundException("존재하지 않는 회원입니다."));
    }

    public void checkPassword(Member member, String password) {
        if(!passwordEncoder.matches(password, member.getPassword())) {
            throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
        }
    }

    public Member getMemberByEmail(String email) {
        return memberRepository.findByEmail(email)
                .orElseThrow(() -> new MemberNotFoundException("멤버를 찾을 수 없습니다."));
    }

    public Long getMemberId() {
        return getCurrentMember().getId();
    }

    public boolean verifyMemberIsTeacher(Member member){
        return member.getRole() == Role.TEACHER;
    }

    public void verifyMemberQualification(Member member){
        if (verifyMemberIsTeacher(member))
            throw new UnqualifiedMarketMemberException("선생님은 마켓 소비자가 될 수 없습니다.");
    }

    public void verifyMemberAlreadyRegisteredMarket(Member member){
        Market market = member.getMarket();
        if(!Objects.isNull(market))
            throw new AlreadyRegisterMarketException("이미 상점 마켓에 가입된 사용자입니다.");
    }

}
