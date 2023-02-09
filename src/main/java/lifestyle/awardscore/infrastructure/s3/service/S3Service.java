package lifestyle.awardscore.infrastructure.s3.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface S3Service {
    List<String> uploadFiles(List<MultipartFile> multipartFiles, String dirName);
    String uploadFile(MultipartFile multipartFiles, String dirName);
    void deleteFile(String fileName);
    String createFileName(String fileName);
    String getFileExtension(String fileName);
}
