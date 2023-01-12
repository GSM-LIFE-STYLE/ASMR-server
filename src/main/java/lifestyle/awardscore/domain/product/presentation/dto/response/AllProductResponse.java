package lifestyle.awardscore.domain.product.presentation.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AllProductResponse {
    private final Long productId;
    private final String productName;
    private final String price;
}
