package lifestyle.awardscore.domain.notice.presentation;

import lifestyle.awardscore.domain.notice.presentation.dto.request.WriteNoticeRequest;
import lifestyle.awardscore.domain.notice.service.ViewNoticeService;
import lifestyle.awardscore.domain.notice.service.WriteNoticeService;
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
@RequestMapping("/notice")
public class NoticeController {

    private final WriteNoticeService writeNoticeService;
    public final ViewNoticeService viewNoticeService;

    @PostMapping("/write")
    public ResponseEntity<Void> WriteNotice(@RequestBody @Valid WriteNoticeRequest request) {
        writeNoticeService.execute(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
