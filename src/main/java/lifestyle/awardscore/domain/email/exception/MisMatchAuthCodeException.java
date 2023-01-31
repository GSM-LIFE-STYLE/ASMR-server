package lifestyle.awardscore.domain.email.exception;

import lifestyle.awardscore.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class MisMatchAuthCodeException extends RuntimeException {
    private final ErrorCode errorCode;

    public MisMatchAuthCodeException(String message) {
        super(message);
        this.errorCode = ErrorCode.MISMATCH_AUTH_CODE;
    }
}
