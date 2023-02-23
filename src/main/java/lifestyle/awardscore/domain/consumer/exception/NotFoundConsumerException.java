package lifestyle.awardscore.domain.consumer.exception;

import lifestyle.awardscore.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class NotFoundConsumerException extends RuntimeException{
    private final ErrorCode errorCode;

    public NotFoundConsumerException(String message){
        super(message);
        this.errorCode = ErrorCode.NOT_FOUND_CONSUMER;
    }
}
