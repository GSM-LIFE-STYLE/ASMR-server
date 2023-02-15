package lifestyle.awardscore.domain.notice.exception;

import lifestyle.awardscore.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class UnqualifiedNoticeWriterException extends RuntimeException {

    private final ErrorCode errorCode;

    public UnqualifiedNoticeWriterException(String message) {
        super(message);
        this.errorCode = ErrorCode.UNQUALIFIED_NOTICE_WRITER;
    }
}
