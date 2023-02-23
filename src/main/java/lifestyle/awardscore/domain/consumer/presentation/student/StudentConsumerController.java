package lifestyle.awardscore.domain.consumer.presentation.student;

import lifestyle.awardscore.domain.consumer.service.ExitMarketService;
import lifestyle.awardscore.domain.consumer.service.RegisterMarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student/consumer")
public class StudentConsumerController {

    private final RegisterMarketService registerMarketService;
    private final ExitMarketService exitMarketService;

    @PostMapping("/register")
    public ResponseEntity<Void> registerMarket(@RequestParam Long marketId){
        registerMarketService.execute(marketId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/exit")
    public ResponseEntity<Void> exitMarket(@RequestParam Long marketId){
        exitMarketService.execute(marketId);
        return ResponseEntity.ok().build();
    }
}
