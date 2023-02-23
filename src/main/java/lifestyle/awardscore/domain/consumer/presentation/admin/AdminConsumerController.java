package lifestyle.awardscore.domain.consumer.presentation.admin;

import lifestyle.awardscore.domain.consumer.service.ExitMarketService;
import lifestyle.awardscore.domain.consumer.service.RegisterMarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/consumer")
public class AdminConsumerController {
    private final RegisterMarketService registerMarketService;
    private final ExitMarketService exitMarketService;

    @PatchMapping("/{marketId}/register")
    public ResponseEntity<Void> registerMarket(@PathVariable Long marketId){
        registerMarketService.execute(marketId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{marketId}/exit")
    public ResponseEntity<Void> exitMarket(@PathVariable Long marketId){
        exitMarketService.execute(marketId);
        return ResponseEntity.ok().build();
    }
}
