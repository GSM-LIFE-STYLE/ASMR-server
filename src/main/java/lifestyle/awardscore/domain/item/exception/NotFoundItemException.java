package lifestyle.awardscore.domain.item.exception;

import lifestyle.awardscore.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class NotFoundItemException extends RuntimeException{

    private final ErrorCode errorCode;

    public NotFoundItemException(String message){
        super(message);
        this.errorCode = ErrorCode.NOT_FOUND_ITEM;
    }
}
