package lifestyle.awardscore.domain.item.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateItemRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotNull
    private Integer price;

    private String previewUrl;
}
