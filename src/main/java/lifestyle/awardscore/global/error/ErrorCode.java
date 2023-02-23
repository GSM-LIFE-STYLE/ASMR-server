package lifestyle.awardscore.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    MANY_REQUEST_EMAIL_AUTH("15분에 최대 3번의 이메일 요청만 가능합니다." , 429),
    EXPIRE_EMAIL_CODE("이메일 인증번호 시간이 만료되었습니다.", 401),
    MEMBER_NOT_FOUND("존재하지 않는 회원입니다.", 404),
    MISMATCH_AUTH_CODE("인증번호가 일치하지 않습니다." , 400),
    NOT_VERIFY_EMAIL("검증되지 않은 이메일입니다." , 401),
    MISMATCH_MEMBER_PASSWORD("비밀번호가 일치하지 않습니다.", 400),
    ALREADY_EXIST_EMAIL("이미 존재하는 이메일입니다." , 400),
    ALREADY_EXIST_ID("이미 존재하는 아이디입니다.", 400),
    TOKEN_NOT_VALID("토큰이 유효 하지 않습니다.", 401),
    TOKEN_EXPIRATION("토큰이 만료 되었습니다.", 401),
    NOT_FOUND_ORDER("존재하지 않는 주문입니다." , 404),
    NOT_FOUND_ITEM("존재하지 않는 상점마켓입니다.", 404),
    ALREADY_OWNER("이미 마켓을 등록하셨습니다." ,400),
    ALREADY_EXIST_REFRESH_TOKEN("이미 존재하는 리프레시 토큰입니다.", 409),
    REFRESH_TOKEN_NOT_FOUND("존재하지 않는 리프레시 토큰입니다.", 404),
    FORBIDDEN_ACCESS_ITEM("아이템 정보에 접근할 수 있는 권한이 없습니다.", 403),
    UNQUALIFIED_MARKET_OWNER("상점 주인이 될 자격이 없는 멤버입니다..", 403),
    UNQUALIFIED_NOTICE_WRITER("공지글을 작성할 권한이 없습니다.", 403),
    UNQUALIFIED_MARKET_MEMBER("선생님은 상점마켓 소비자가 될 수 없습니다.",403),
    ALREADY_REGISTER_MEMBER("이미 상점마켓에 가입된 멤버입니다.",403),
    NOT_FOUND_CONSUMER("존재하지 않는 소비자입니다.", 404),
    NOT_FOUND_NOTICE("공지가 존재하지 않습니다.", 404);

    private final String message;
    private final int status;
}
