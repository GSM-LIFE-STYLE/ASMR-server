package lifestyle.awardscore.domain.item.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateItemRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String content;

    private String previewUrl;
}
