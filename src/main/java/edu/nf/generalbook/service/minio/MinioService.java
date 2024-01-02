package edu.nf.generalbook.service.minio;

import edu.nf.generalbook.entity.User;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author：tianyuan
 * @Date：2023/12/6 20:25
 */
public interface MinioService {
    /**
     * 创建桶
     * @param bucketName
     * @throws Exception
     */
    void createBucket(String bucketName) throws Exception;


    /**
     * 图片上传并返回图片地址
     * @param file
     * @return
     */
    String uploadFile(MultipartFile file);


}
