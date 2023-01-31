package lifestyle.awardscore.domain.member.exception;

import lifestyle.awardscore.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class MemberNotFoundException extends RuntimeException {
    private final ErrorCode errorCode;

    public MemberNotFoundException(String message) {
        super(message);
        this.errorCode = ErrorCode.MEMBER_NOT_FOUND;
    }
}
