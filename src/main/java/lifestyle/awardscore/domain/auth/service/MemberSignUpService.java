package lifestyle.awardscore.domain.auth.service;

import lifestyle.awardscore.domain.email.entity.EmailAuth;
import lifestyle.awardscore.domain.email.facade.EmailFacade;
import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.member.repository.MemberRepository;
import lifestyle.awardscore.domain.auth.exception.ExistEmailException;
import lifestyle.awardscore.domain.auth.presentation.dto.request.MemberSignUpRequest;
import lifestyle.awardscore.global.filter.role.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberSignUpService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;
    private final EmailFacade emailFacade;

    @Transactional(rollbackFor = Exception.class)
    public void execute(MemberSignUpRequest signUpRequest) {

        if(memberRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new ExistEmailException("이미 존재하는 이메일입니다.");
        }

        EmailAuth emailAuth = emailFacade.getEmailEntityById(signUpRequest.getEmail());

        emailFacade.checkEmailAuthentication(emailAuth);

        Member member = Member
                .builder()
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .studentName(signUpRequest.getName())
                .studentNumber(signUpRequest.getNumber())
                .role(Role.from(signUpRequest.getRole()))
                .build();

        memberRepository.save(member);
    }
}
