package lifestyle.awardscore.domain.auth.exception;

import lifestyle.awardscore.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class BlackListAlreadyExistException extends RuntimeException {

    private final ErrorCode errorCode;

    public BlackListAlreadyExistException(String message) {
        super(message);
        this.errorCode = ErrorCode.ALREADY_EXIST_REFRESH_TOKEN;
    }
}
