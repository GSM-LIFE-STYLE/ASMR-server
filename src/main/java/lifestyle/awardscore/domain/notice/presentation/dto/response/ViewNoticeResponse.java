package lifestyle.awardscore.domain.notice.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ViewNoticeResponse {

    private String title;
    private String content;
}
