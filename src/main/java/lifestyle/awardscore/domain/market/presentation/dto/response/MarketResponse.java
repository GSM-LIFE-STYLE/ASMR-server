package lifestyle.awardscore.domain.market.presentation.dto.response;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class MarketResponse {
    private final Long marketId;
    private final String marketName;
    private final String marketOwnerName;
}
