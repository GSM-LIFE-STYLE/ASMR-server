package lifestyle.awardscore.global.exception.collection;

import lifestyle.awardscore.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class TokenExpirationException extends RuntimeException {

    private final ErrorCode errorCode;

    public TokenExpirationException(String message) {
        super(message);
        this.errorCode = ErrorCode.TOKEN_EXPIRATION;
    }
}
