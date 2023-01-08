package lifestyle.awardscore.domain.auth.exception;

import lifestyle.awardscore.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class ExistEmailException extends RuntimeException{

    private final ErrorCode errorCode;

    public ExistEmailException(String message) {
        super(message);
        this.errorCode = ErrorCode.ALREADY_EXIST_EMAIL;
    }
}
