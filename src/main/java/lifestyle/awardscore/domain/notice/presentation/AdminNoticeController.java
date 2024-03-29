package lifestyle.awardscore.domain.notice.presentation;

import lifestyle.awardscore.domain.notice.entity.Notice;
import lifestyle.awardscore.domain.notice.presentation.dto.request.WriteNoticeRequest;
import lifestyle.awardscore.domain.notice.presentation.dto.response.ViewNoticeResponse;
import lifestyle.awardscore.domain.notice.service.ViewNoticeService;
import lifestyle.awardscore.domain.notice.service.WriteNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminNoticeController {

    private final WriteNoticeService writeNoticeService;
    public final ViewNoticeService viewNoticeService;

    @PostMapping("/write")
    public ResponseEntity<Void> writeNotice(@RequestBody @Valid WriteNoticeRequest request) {
        writeNoticeService.execute(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ViewNoticeResponse>> viewNotice() {
        List<ViewNoticeResponse> response = viewNoticeService.execute();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
