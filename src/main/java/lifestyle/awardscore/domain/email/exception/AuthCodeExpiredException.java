package lifestyle.awardscore.domain.email.exception;

import lifestyle.awardscore.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class AuthCodeExpiredException extends RuntimeException{
    private final ErrorCode errorCode;

    public AuthCodeExpiredException(String message) {
        super(message);
        this.errorCode = ErrorCode.EXPIRE_EMAIL_CODE;
    }
}
