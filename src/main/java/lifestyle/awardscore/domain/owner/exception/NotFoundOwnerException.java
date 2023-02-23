package lifestyle.awardscore.domain.owner.exception;

import lifestyle.awardscore.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class NotFoundOwnerException extends RuntimeException{
    private final ErrorCode errorCode;

    public NotFoundOwnerException(String message){
        super(message);
        this.errorCode = ErrorCode.NOT_FOUND_OWNER;
    }
}
