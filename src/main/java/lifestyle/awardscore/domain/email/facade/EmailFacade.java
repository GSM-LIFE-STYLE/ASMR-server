package lifestyle.awardscore.domain.email.facade;

import lifestyle.awardscore.domain.auth.exception.NotVerifyEmailException;
import lifestyle.awardscore.domain.email.entity.EmailAuth;
import lifestyle.awardscore.domain.email.repository.EmailAuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EmailFacade {
    private final EmailAuthRepository emailAuthRepository;

    public EmailAuth getEmailEntityById(String email) {
        return emailAuthRepository.findById(email)
                .orElseThrow(() -> new NotVerifyEmailException("검증되지 않은 이메일입니다."));
    }
}
