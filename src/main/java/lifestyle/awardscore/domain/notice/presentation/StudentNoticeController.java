package lifestyle.awardscore.domain.notice.presentation;

import lifestyle.awardscore.domain.notice.presentation.dto.response.ViewNoticeResponse;
import lifestyle.awardscore.domain.notice.service.ViewNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentNoticeController {

    public final ViewNoticeService viewNoticeService;

    @GetMapping
    public ResponseEntity<List<ViewNoticeResponse>> viewNotice() {
        List<ViewNoticeResponse> response = viewNoticeService.execute();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
