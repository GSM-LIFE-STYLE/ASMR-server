package lifestyle.awardscore.domain.email.service;

import lifestyle.awardscore.domain.email.entity.EmailAuth;
import lifestyle.awardscore.domain.email.exception.MisMatchAuthCodeException;
import lifestyle.awardscore.domain.email.facade.EmailFacade;
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
    private final EmailFacade emailFacade;

    /**
     * 이메일 인증키와 입력한 인증키가 일치하면 이메일 검증 엔티티를 저장하는 서비스 로직
     * @param email
     * @param authKey
     * @author 김희망
     */
    @Transactional(rollbackFor = Exception.class)
    public void execute(String email , String authKey) {
        EmailAuth emailAuthEntity = emailFacade.getEmailEntityById(email);
        checkAuthKey(emailAuthEntity,authKey);
        emailAuthEntity.updateAuthentication(true);
        emailAuthRepository.save(emailAuthEntity);
    }

    /**
     * 인증번호가 일치한지 검증하는 서비스 로직
     * @param emailAuthEntity
     * @param authKey
     * @author 김희망
     */
    private void checkAuthKey(EmailAuth emailAuthEntity, String authKey) {
        if(!Objects.equals(emailAuthEntity.getRandomValue(), authKey)){
            throw new MisMatchAuthCodeException("인증번호가 일치하지 않습니다.");
        }
    }
}
