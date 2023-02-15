package lifestyle.awardscore.domain.item.exception;

import lifestyle.awardscore.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class ForbiddenAccessItemException extends RuntimeException {
    private final ErrorCode errorCode;

    public ForbiddenAccessItemException(String message){
        super(message);
        this.errorCode = ErrorCode.FORBIDDEN_ACCESS_ITEM;
    }
}
