package lifestyle.awardscore.domain.notice.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WriteNoticeRequest {

    @NotBlank(message = "제목은 공백을 허용하지 않습니다.")
    private String title;

    @NotBlank(message = "내용은 공백을 허용하지 않습니다.")
    private String content;

}
