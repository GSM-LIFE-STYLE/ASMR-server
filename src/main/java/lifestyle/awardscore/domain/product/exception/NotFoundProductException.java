package lifestyle.awardscore.domain.product.exception;

import lifestyle.awardscore.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class NotFoundProductException extends RuntimeException {
    private final ErrorCode errorCode;

    public NotFoundProductException(String message) {
        super(message);
        this.errorCode = ErrorCode.NOT_FOUND_PRODUCT;
    }
}
