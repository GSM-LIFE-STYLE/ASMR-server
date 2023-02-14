package lifestyle.awardscore.domain.market.presentation.teacher;

import lifestyle.awardscore.domain.item.presentation.dto.CreateItemRequest;
import lifestyle.awardscore.domain.item.service.CreateItemService;
import lifestyle.awardscore.domain.market.presentation.dto.request.CreateMarketRequest;
import lifestyle.awardscore.domain.market.service.CreateMarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teacher/market")
public class TeacherMarketController {

    private final CreateMarketService createMarketService;
    private final CreateItemService createItemService;

    @PostMapping("/register")
    public ResponseEntity<Void> createMarket(@Valid @RequestBody CreateMarketRequest request) {
        createMarketService.execute(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{marketId}/item")
    public ResponseEntity<Void> createItem(@PathVariable Long marketId, @Valid @RequestBody CreateItemRequest request){
        createItemService.execute(marketId, request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
