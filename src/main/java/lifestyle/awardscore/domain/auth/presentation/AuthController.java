package lifestyle.awardscore.domain.auth.presentation;

import lifestyle.awardscore.domain.auth.presentation.dto.request.MemberLoginRequest;
import lifestyle.awardscore.domain.auth.presentation.dto.request.MemberSignUpRequest;
import lifestyle.awardscore.domain.auth.presentation.dto.response.TokenResponse;
import lifestyle.awardscore.domain.auth.service.MemberLoginService;
import lifestyle.awardscore.domain.auth.service.MemberSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final MemberSignUpService memberSignUpService;
    private final MemberLoginService memberLoginService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@RequestBody @Valid MemberSignUpRequest signUpRequest) {
        memberSignUpService.execute(signUpRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody @Valid MemberLoginRequest loginRequest) {
        TokenResponse data = memberLoginService.login(loginRequest);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
