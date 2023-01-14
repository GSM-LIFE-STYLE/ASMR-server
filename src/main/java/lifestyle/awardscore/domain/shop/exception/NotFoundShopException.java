package lifestyle.awardscore.domain.shop.exception;

import lifestyle.awardscore.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class NotFoundShopException extends RuntimeException{

    private final ErrorCode errorCode;

    public NotFoundShopException(String message) {
        super(message);
        this.errorCode = ErrorCode.NOT_FOUND_SHOP;
    }
}
