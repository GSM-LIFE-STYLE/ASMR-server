package lifestyle.awardscore.global.role;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Role {
    ADMIN,TEACHER,STUDENT;

    @JsonCreator
    public static Role from(String s) {
        return Role.valueOf(s.toUpperCase());
    }
}
