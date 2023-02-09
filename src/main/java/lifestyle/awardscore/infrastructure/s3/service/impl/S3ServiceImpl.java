package lifestyle.awardscore.infrastructure.s3.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import lifestyle.awardscore.infrastructure.s3.properties.S3BucketProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class S3ServiceImpl {

    private final AmazonS3 amazonS3;
    private final S3BucketProperties s3BucketProperties;

}
