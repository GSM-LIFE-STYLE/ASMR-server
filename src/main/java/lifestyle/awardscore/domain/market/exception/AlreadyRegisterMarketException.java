package lifestyle.awardscore.domain.market.exception;

import lifestyle.awardscore.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class AlreadyRegisterMarketException extends RuntimeException{
    private final ErrorCode errorCode;

    public AlreadyRegisterMarketException(String message){
        super(message);
        this.errorCode = ErrorCode.ALREADY_REGISTER_MEMBER;
    }
}
