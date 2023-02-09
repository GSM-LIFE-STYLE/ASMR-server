package lifestyle.awardscore.infrastructure.s3.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lifestyle.awardscore.infrastructure.s3.properties.S3BucketProperties;
import lifestyle.awardscore.infrastructure.s3.service.S3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class S3ServiceImpl implements S3Service {

    private final AmazonS3 amazonS3;
    private final S3BucketProperties s3BucketProperties;

    @Override
    public List<String> uploadFiles(List<MultipartFile> multipartFiles, String dirName) {

        List<String> fileNameList = new ArrayList<>();

        multipartFiles.forEach(file -> {

            String fileName = createFileName(file.getOriginalFilename());

            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(file.getSize());
            objectMetadata.setContentType(file.getContentType());

            try(InputStream inputStream = file.getInputStream()) {
                amazonS3.putObject(new PutObjectRequest(s3BucketProperties.getBucket(), dirName + fileName, inputStream, objectMetadata)
                        .withCannedAcl(CannedAccessControlList.PublicRead));
            } catch (IOException e) {
                throw new IllegalStateException("파일 업로드에 실패했습니다");
            }

            fileNameList.add(fileName);

        });

        return fileNameList;
    }

    @Override
    public String uploadFile(MultipartFile multipartFiles, String dirName) {

        String fileName = createFileName(multipartFiles.getOriginalFilename());

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(multipartFiles.getSize());
        objectMetadata.setContentType(multipartFiles.getContentType());

        try(InputStream inputStream = multipartFiles.getInputStream()) {
            amazonS3.putObject(new PutObjectRequest(s3BucketProperties.getBucket(), dirName + fileName, inputStream, objectMetadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (IOException e) {
            throw new IllegalStateException("파일 업로드에 실패했습니다");
        }

        return fileName;
    }

    @Override
    public void deleteFile(String fileName) {
        amazonS3.deleteObject(new DeleteObjectRequest(s3BucketProperties.getBucket(), fileName));
    }

    @Override
    public String createFileName(String fileName) {
        return UUID.randomUUID().toString().concat(getFileExtension(fileName));
    }

    @Override
    public String getFileExtension(String fileName) {
        try {
            return fileName.substring(fileName.lastIndexOf("."));
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("잘못된 형식의 파일입니다.");
        }
    }

}
