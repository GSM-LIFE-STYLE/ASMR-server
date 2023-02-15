package lifestyle.awardscore.domain.market.exception;

import lifestyle.awardscore.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class NotFoundMarketException extends RuntimeException{
    private final ErrorCode errorCode;

    public NotFoundMarketException(String message){
        super(message);
        this.errorCode = ErrorCode.NOT_FOUND_ITEM;
    }
}
