package lifestyle.awardscore.domain.auth.exception;

import lifestyle.awardscore.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class NotFoundRefreshTokenException extends RuntimeException{
    private final ErrorCode errorCode;

    public NotFoundRefreshTokenException(String message) {
        super(message);
        this.errorCode = ErrorCode.REFRESH_TOKEN_NOT_FOUND;
    }
}
