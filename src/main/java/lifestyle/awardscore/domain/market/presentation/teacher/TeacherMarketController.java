package lifestyle.awardscore.domain.market.presentation.teacher;

import lifestyle.awardscore.domain.item.presentation.dto.request.CreateItemRequest;
import lifestyle.awardscore.domain.item.service.CreateItemService;
import lifestyle.awardscore.domain.market.presentation.dto.request.CreateMarketRequest;
import lifestyle.awardscore.domain.market.presentation.dto.response.MarketResponse;
import lifestyle.awardscore.domain.market.service.CreateMarketService;
import lifestyle.awardscore.domain.market.service.LookUpAllMarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teacher/market")
public class TeacherMarketController {

    private final CreateMarketService createMarketService;
    private final CreateItemService createItemService;
    private final LookUpAllMarketService lookUpAllMarketService;

    @PostMapping("/register")
    public ResponseEntity<Void> createMarket(@Valid @RequestBody CreateMarketRequest request) {
        createMarketService.execute(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{marketId}/item")
    public ResponseEntity<Void> createItem(@PathVariable Long marketId,
                                           @Valid @RequestPart(value = "itemDto") CreateItemRequest request,
                                           @Valid @RequestPart(value = "files", required = false) MultipartFile multipartFile){
        createItemService.execute(marketId, request, multipartFile);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<MarketResponse>> lookUpAllMarket(){
        List<MarketResponse> responses = lookUpAllMarketService.execute();
        return ResponseEntity.ok(responses);
    }

}
