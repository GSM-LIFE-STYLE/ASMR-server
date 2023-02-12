package lifestyle.awardscore.domain.member.presentation;

import io.swagger.annotations.ApiOperation;
import lifestyle.awardscore.domain.member.presentation.dto.request.ChangePasswordRequest;
import lifestyle.awardscore.domain.member.service.ChangePasswordService;
import lifestyle.awardscore.domain.member.service.WithdrawService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final WithdrawService withdrawService;
    private final ChangePasswordService changePasswordService;

    @PatchMapping("/change-pw")
    public ResponseEntity<Void> changePassword(@RequestBody @Validated ChangePasswordRequest changePasswordRequest) {
        changePasswordService.changePassword(changePasswordRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    @ApiOperation(value = "회원탈퇴")
    public ResponseEntity<Void> withdraw(@RequestParam String password) {
        withdrawService.execute(password);
        return ResponseEntity.ok().build();
    }
}
