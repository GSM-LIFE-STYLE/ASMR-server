package lifestyle.awardscore.domain.market.presentation.teacher;

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
@RequestMapping("/teacher/market")
public class TeacherMarketController {

    private final CreateMarketService createMarketService;

    @PostMapping("/register")
    public ResponseEntity<Void> createMarket(@Valid @RequestBody CreateMarketRequest request) {
        createMarketService.execute(request);
        return ResponseEntity.ok().build();
    }

}
