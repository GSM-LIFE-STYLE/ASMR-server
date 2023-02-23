package lifestyle.awardscore.domain.market.presentation.student;

import lifestyle.awardscore.domain.item.presentation.dto.response.ItemResponse;
import lifestyle.awardscore.domain.market.presentation.dto.response.MarketResponse;
import lifestyle.awardscore.domain.market.service.LookUpAllMarketService;
import lifestyle.awardscore.domain.market.service.LookUpMarketService;
import lifestyle.awardscore.domain.consumer.service.RegisterMarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student/market")
public class StudentMarketController {

    private final LookUpAllMarketService lookUpAllMarketService;
    private final LookUpMarketService lookUpMarketService;

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

}
