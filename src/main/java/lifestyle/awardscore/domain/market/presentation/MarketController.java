package lifestyle.awardscore.domain.market.presentation;

import lifestyle.awardscore.domain.market.presentation.dto.request.CreateMarketRequest;
import lifestyle.awardscore.domain.market.service.CreateMarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/market")
public class MarketController {

    private final CreateMarketService createMarketService;

    @PostMapping
    public ResponseEntity<Void> createMarket(@Valid @RequestBody CreateMarketRequest request) {
        createMarketService.execute(request);
        return ResponseEntity.ok().build();
    }

}
