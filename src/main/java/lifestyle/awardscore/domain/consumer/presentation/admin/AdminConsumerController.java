package lifestyle.awardscore.domain.consumer.presentation.admin;

import lifestyle.awardscore.domain.consumer.service.RegisterMarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/consumer")
public class AdminConsumerController {
    private final RegisterMarketService registerMarketService;

    @PatchMapping("/{marketId}/register")
    public ResponseEntity<Void> registerMarket(@PathVariable Long marketId){
        registerMarketService.execute(marketId);
        return ResponseEntity.noContent().build();
    }
}
