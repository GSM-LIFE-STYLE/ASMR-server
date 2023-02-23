package lifestyle.awardscore.domain.owner.presentation;

import lifestyle.awardscore.domain.owner.service.InviteMarketMemberService;
import lifestyle.awardscore.domain.owner.service.WithdrawMarketMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/owner")
public class OwnerController {

    private final InviteMarketMemberService inviteMarketMemberService;
    private final WithdrawMarketMemberService withdrawMarketMemberService;

    @PostMapping("/invite")
    public ResponseEntity<Void> inviteMember(@RequestParam Long marketId, @RequestParam Long memberId){
        inviteMarketMemberService.execute(marketId, memberId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/withdraw")
    public ResponseEntity<Void> withdrawMember(@RequestParam Long marketId, @RequestParam Long memberId){
        withdrawMarketMemberService.execute(marketId, memberId);
        return ResponseEntity.ok().build();
    }
}
