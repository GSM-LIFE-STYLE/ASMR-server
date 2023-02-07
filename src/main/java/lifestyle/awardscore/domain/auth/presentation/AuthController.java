package lifestyle.awardscore.domain.auth.presentation;

import io.swagger.annotations.ApiOperation;
import lifestyle.awardscore.domain.auth.presentation.dto.request.MemberLoginRequest;
import lifestyle.awardscore.domain.auth.presentation.dto.request.MemberSignUpRequest;
import lifestyle.awardscore.domain.auth.presentation.dto.response.TokenResponse;
import lifestyle.awardscore.domain.auth.service.MemberLoginService;
import lifestyle.awardscore.domain.auth.service.MemberLogoutService;
import lifestyle.awardscore.domain.auth.service.MemberSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final MemberSignUpService memberSignUpService;
    private final MemberLoginService memberLoginService;
    private final MemberLogoutService memberLogoutService;

    @PostMapping("/signup")
    @ApiOperation(value = "회원가입")
    public ResponseEntity<Void> signUp(@RequestBody @Valid MemberSignUpRequest signUpRequest) {
        memberSignUpService.execute(signUpRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    @ApiOperation(value = "로그인")
    public ResponseEntity<TokenResponse> login(@RequestBody @Valid MemberLoginRequest loginRequest) {
        TokenResponse data = memberLoginService.login(loginRequest);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> logout(@RequestHeader("Authorization") String accessToken) {
        memberLogoutService.logout(accessToken);
        return ResponseEntity.noContent().build();
    }
}
