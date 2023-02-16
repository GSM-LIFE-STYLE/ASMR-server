package lifestyle.awardscore.domain.notice.exception;

import lifestyle.awardscore.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class NotFoundNoticeException extends RuntimeException {

    private final ErrorCode errorCode;

    public NotFoundNoticeException(String message) {
        super(message);
        this.errorCode = ErrorCode.NOT_FOUND_NOTICE;
    }
}
