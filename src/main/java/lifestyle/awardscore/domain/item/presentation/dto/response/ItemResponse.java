package lifestyle.awardscore.domain.item.presentation.dto.response;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class ItemResponse {
    private final Long itemId;
    private final String title;
    private final String price;
}
