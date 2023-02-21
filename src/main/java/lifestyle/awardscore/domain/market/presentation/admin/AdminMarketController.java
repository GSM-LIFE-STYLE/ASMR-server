package lifestyle.awardscore.domain.market.presentation.admin;

import lifestyle.awardscore.domain.item.presentation.dto.response.ItemResponse;
import lifestyle.awardscore.domain.market.presentation.dto.response.MarketResponse;
import lifestyle.awardscore.domain.market.service.DeleteMarketService;
import lifestyle.awardscore.domain.market.service.LookUpAllMarketService;
import lifestyle.awardscore.domain.market.service.LookUpMarketService;
import lifestyle.awardscore.domain.market.service.UpdateMarketNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/market")
public class AdminMarketController {

    private final LookUpAllMarketService lookUpAllMarketService;
    private final LookUpMarketService lookUpMarketService;
    private final UpdateMarketNameService updateMarketNameService;
    private final DeleteMarketService deleteMarketService;

    @GetMapping
    public ResponseEntity<List<MarketResponse>> lookUpAllMarket(){
        List<MarketResponse> responses = lookUpAllMarketService.execute();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{marketId}")
    public ResponseEntity<List<ItemResponse>> lookUpMarket(@PathVariable Long marketId){
        List<ItemResponse> responses = lookUpMarketService.execute(marketId);
        return ResponseEntity.ok(responses);
    }

    @PatchMapping("/{marketId}")
    public ResponseEntity<Void> updateMarket(@PathVariable Long marketId, @RequestParam String newMarketName) {
        updateMarketNameService.execute(marketId, newMarketName);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{marketId}")
    public ResponseEntity<Void> deleteMarket(@PathVariable Long marketId){
        deleteMarketService.execute(marketId);
        return ResponseEntity.ok().build();
    }
}

