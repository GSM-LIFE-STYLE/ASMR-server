package lifestyle.awardscore.global.security.exception;

import lifestyle.awardscore.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class TokenNotValidException extends RuntimeException{

    private final ErrorCode errorCode;

    public TokenNotValidException(String message) {
        super(message);
        this.errorCode = ErrorCode.TOKEN_NOT_VALID;
    }
}
