package lifestyle.awardscore.domain.shop.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterShopRequest {
    private long itemId;
    private String shopName;
}
