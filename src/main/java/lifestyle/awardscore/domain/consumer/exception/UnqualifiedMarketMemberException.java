package lifestyle.awardscore.domain.consumer.exception;

import lifestyle.awardscore.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class UnqualifiedMarketMemberException extends RuntimeException {
    private final ErrorCode errorCode;

    public UnqualifiedMarketMemberException(String message){
        super(message);
        this.errorCode = ErrorCode.UNQUALIFIED_MARKET_MEMBER;
    }
}
