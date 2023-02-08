package lifestyle.awardscore.domain.auth.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberSignUpRequest {

    @NotBlank(message = "이메일은 공백을 허용하지 않습니다.")
    private String email;

    @NotBlank(message = "비밀번호는 공백을 허용하지 않습니다.")
    private String password;

    @NotBlank(message = "이름은 공백을 허용하지 않습니다.")
    private String name;

    @NotBlank(message = "학번은 공백을 허용하지 않습니다.")
    private String number;

    @NotBlank(message = "역할은 공백을 허용하지 않습니다.")
    private String role;
}
