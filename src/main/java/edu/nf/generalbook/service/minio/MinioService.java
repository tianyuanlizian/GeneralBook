package edu.nf.generalbook.service.minio;

import edu.nf.generalbook.entity.User;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

/**
 * @Author：tianyuan
 * @Date：2023/12/6 20:25
 */
public interface MinioService {

    void createBucket(String bucketName) throws Exception;

    void uploadImage(User user)  throws Exception;

    ResponseEntity<InputStreamResource> downloadImage(String fileName);

}
