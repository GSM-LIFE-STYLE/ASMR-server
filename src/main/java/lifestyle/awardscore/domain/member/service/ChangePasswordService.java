package lifestyle.awardscore.domain.member.service;

import lifestyle.awardscore.domain.auth.exception.NotVerifyEmailException;
import lifestyle.awardscore.domain.email.entity.EmailAuth;
import lifestyle.awardscore.domain.email.repository.EmailAuthRepository;
import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.member.facade.MemberFacade;
import lifestyle.awardscore.domain.member.presentation.dto.request.ChangePasswordRequest;
import lifestyle.awardscore.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ChangePasswordService {

    private final MemberRepository memberRepository;
    private final EmailAuthRepository emailAuthRepository;
    private final PasswordEncoder passwordEncoder;
    private final MemberFacade memberFacade;


    private void validateAuth(String email) {
        EmailAuth emailAuth = emailAuthRepository.findById(email)
                .orElseThrow(() -> new NotVerifyEmailException("검증되지 않은 이메일입니다."));
        if (!emailAuth.getAuthentication()) {
            throw new NotVerifyEmailException("검증되지 않은 이메일입니다.");
        }
    }

    /**
     * 멤버의 비밀번호를 변경하는 서비스 로직
     * @param changePasswordRequest
     * @author 박주홍
     */

    @Transactional
    public void changePassword(ChangePasswordRequest changePasswordRequest) {
        Member member = memberFacade.getCurrentMember();
        validateAuth(member.getEmail());
        member.updatePassword(passwordEncoder.encode(changePasswordRequest.getPassword()));
        memberRepository.save(member);
    }
}