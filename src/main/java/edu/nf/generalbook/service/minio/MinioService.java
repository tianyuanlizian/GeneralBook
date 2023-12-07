package edu.nf.generalbook.service.minio;

import edu.nf.generalbook.entity.User;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

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
     * 上传头像并保存信息到数据库
     * @param user
     * @throws Exception
     */
    void uploadImage(User user)  throws Exception;

    /**
     * 下载功能
     * @param fileName
     * @return
     */
    ResponseEntity<InputStreamResource> downloadImage(String fileName);

}
