package lifestyle.awardscore.domain.market.exception;

import lifestyle.awardscore.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class UnqualifiedMarketOwnerException extends RuntimeException{
    private final ErrorCode errorCode;

    public UnqualifiedMarketOwnerException(String message) {
        super(message);
        this.errorCode = ErrorCode.UNQUALIFIED_MARKET_OWNER;
    }
}
