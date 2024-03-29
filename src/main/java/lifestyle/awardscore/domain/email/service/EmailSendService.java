package lifestyle.awardscore.domain.email.service;

import lifestyle.awardscore.domain.email.entity.EmailAuth;
import lifestyle.awardscore.domain.email.exception.AuthCodeExpiredException;
import lifestyle.awardscore.domain.email.exception.ManyRequestEmailAuthException;
import lifestyle.awardscore.domain.email.presentation.dto.request.EmailSendRequest;
import lifestyle.awardscore.domain.email.repository.EmailAuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Random;

@Service
@EnableAsync
@RequiredArgsConstructor
public class EmailSendService {

    private final EmailAuthRepository emailAuthRepository;
    private final JavaMailSender mailSender;

    /**
     * 랜덤한 인증번호를 발급해 발송 메서드에 인자를 전달하는 서비스 로직
     * @param emailSentDto email
     * @author 김희망
     */
    @Async
    @Transactional(rollbackFor = Exception.class)
    public void execute(EmailSendRequest emailSentDto){

        Random random = new Random();
        String authKey = String.valueOf(random.nextInt(8888) + 1111);

        sendAuthEmail(emailSentDto.getEmail(),authKey);
    }

    /**
     * 이메일로 인증번호를 발송하는 서비스 로직
     * @param email
     * @param authKey
     * @author 김희망
     */
    private void sendAuthEmail(String email, String authKey) {
        String subject = "ASMR 인증번호";
        String text = "인증을 위한 인증번호는 <strong>" + authKey + "<strong /> 입니다. <br />";
        EmailAuth emailAuthEntity = emailAuthRepository.findById(email)
                .orElse(EmailAuth.builder()
                        .authentication(false)
                        .randomValue(authKey)
                        .attemptCount(0)
                        .email(email)
                        .build());
        if (emailAuthEntity.getAttemptCount() >= 10) {
            throw new ManyRequestEmailAuthException("발송 횟수 초과");
        }

        emailAuthEntity.updateRandomValue(authKey);
        emailAuthEntity.increaseAttemptCount();

        emailAuthRepository.save(emailAuthEntity);
        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true,"utf-8");
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(text,true);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new AuthCodeExpiredException("메일 발송에 실패했습니다");
        }
    }

}
