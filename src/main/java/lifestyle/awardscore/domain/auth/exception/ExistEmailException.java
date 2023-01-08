package lifestyle.awardscore.domain.auth.exception;

import lifestyle.awardscore.global.exception.ErrorCode;

public class ExistEmailException extends RuntimeException{

    private final ErrorCode errorCode;

    public ExistEmailException(String message) {
        super(message);
        this.errorCode = ErrorCode.ALREADY_EXIST_EMAIL;
    }
}
