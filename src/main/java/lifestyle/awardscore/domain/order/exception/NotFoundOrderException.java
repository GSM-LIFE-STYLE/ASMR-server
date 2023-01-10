package lifestyle.awardscore.domain.order.exception;

import lifestyle.awardscore.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class NotFoundOrderException extends RuntimeException {

    private final ErrorCode errorCode;

    public NotFoundOrderException(String message) {
        super(message);
        this.errorCode = ErrorCode.NOT_FOUND_ORDER;
    }
}
