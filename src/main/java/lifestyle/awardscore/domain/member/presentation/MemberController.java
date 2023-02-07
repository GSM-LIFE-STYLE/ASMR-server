package lifestyle.awardscore.domain.member.presentation;

import io.swagger.annotations.ApiOperation;
import lifestyle.awardscore.domain.member.service.WithdrawService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final WithdrawService withdrawService;

    @DeleteMapping
    @ApiOperation(value = "회원탈퇴")
    public ResponseEntity<Void> withdraw(@RequestParam String password) {
        withdrawService.execute(password);
        return ResponseEntity.ok().build();
    }
}
