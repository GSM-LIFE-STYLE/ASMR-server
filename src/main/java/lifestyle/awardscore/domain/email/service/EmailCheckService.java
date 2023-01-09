package lifestyle.awardscore.domain.email.service;

import lifestyle.awardscore.domain.email.entity.EmailAuth;
import lifestyle.awardscore.domain.email.exception.MisMatchAuthCodeException;
import lifestyle.awardscore.domain.email.repository.EmailAuthRepository;
import lifestyle.awardscore.domain.member.exception.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EmailCheckService {

    private final EmailAuthRepository emailAuthRepository;

    @Transactional(rollbackFor = Exception.class)
    public void execute(String email , String authKey) {
        EmailAuth emailAuthEntity = emailAuthRepository.findById(email)
                .orElseThrow(()-> new MemberNotFoundException("유저를 찾을 수 없습니다."));
        checkAuthKey(emailAuthEntity,authKey);
        emailAuthEntity.updateAuthentication(true);
        emailAuthRepository.save(emailAuthEntity);
    }

    private void checkAuthKey(EmailAuth emailAuthEntity, String authKey) {
        if(!Objects.equals(emailAuthEntity.getRandomValue(), authKey)){
            throw new MisMatchAuthCodeException("인증번호가 일치하지 않습니다.");
        }
    }
}
