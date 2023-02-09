package lifestyle.awardscore.infrastructure.s3.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(value = "cloud.aws.s3")
public class S3BucketProperties {
    private String bucket;
}
