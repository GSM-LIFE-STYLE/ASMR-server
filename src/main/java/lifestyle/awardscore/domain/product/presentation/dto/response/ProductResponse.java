package lifestyle.awardscore.domain.product.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter @Builder
@RequiredArgsConstructor
public class ProductResponse {
    private final Long productId;
    private final String productName;
    private final Long price;
    private final String description;
}
