package lifestyle.awardscore.domain.market.exception;


import lifestyle.awardscore.global.error.ErrorCode;

public class AlreadyMarketOwnerException extends RuntimeException {
    private final ErrorCode errorCode;

    public AlreadyMarketOwnerException(String message) {
        super(message);
        this.errorCode = ErrorCode.ALREADY_OWNER;
    }

}
