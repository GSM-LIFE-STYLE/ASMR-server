package lifestyle.awardscore.domain.auth.exception;

import lifestyle.awardscore.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class PasswordMismatchException extends RuntimeException {
    private final ErrorCode errorCode;

    public PasswordMismatchException(String message) {
        super(message);
        this.errorCode = ErrorCode.MISMATCH_MEMBER_PASSWORD;
    }
}
