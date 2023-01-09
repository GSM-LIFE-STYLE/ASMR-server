package lifestyle.awardscore.domain.email.presentation;

import lifestyle.awardscore.domain.email.presentation.dto.request.EmailSendRequest;
import lifestyle.awardscore.domain.email.service.EmailCheckService;
import lifestyle.awardscore.domain.email.service.EmailSendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {

    private final EmailSendService emailSendService;
    private final EmailCheckService emailCheckService;

    @PostMapping(name = "send", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> sendEmail(@Valid @RequestBody EmailSendRequest request) {
        emailSendService.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(method = RequestMethod.HEAD)
    public ResponseEntity<Void> mailCheck(@Email @RequestParam String email, @RequestParam String authKey) {
        emailCheckService.execute(email, authKey);
        return ResponseEntity.ok().build();
    }
}
