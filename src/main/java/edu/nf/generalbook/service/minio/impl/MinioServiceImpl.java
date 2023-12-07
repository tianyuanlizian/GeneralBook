package edu.nf.generalbook.service.minio.impl;

import edu.nf.generalbook.dao.UserDao;
import edu.nf.generalbook.entity.User;
import io.minio.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * @Author：tianyuan
 * @Date：2023/12/6 20:26
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MinioServiceImpl {

    private static MinioClient minioClient;

    private final UserDao dao;
    @Autowired
    public static void setMinioClient(MinioClient minioClient) {
        MinioServiceImpl.minioClient = minioClient;
    }

    private String bucketName = "user";
    /**
     * 创建桶
     * @param bucketName
     */
    public static void createBucket(String bucketName) throws Exception{
        //先判断同是否存在，不存在则创建
        if(!minioClient.bucketExists(BucketExistsArgs.builder()
                .bucket(bucketName).build())) {
            minioClient.makeBucket(MakeBucketArgs.builder()
                    .bucket(bucketName).build());
        }
    }

    /**
     * path路径参数就是桶下面的子目录
     * @return
     */
    public String uploadImage(User user) throws Exception {
        // 生成唯一的文件名，避免重复
        String fileName = UUID.randomUUID().toString() + "_" + user.getImage().getOriginalFilename();

        // 使用MinIO客户端上传文件
        ObjectWriteResponse objectWriteResponse = minioClient.putObject(
                io.minio.PutObjectArgs.builder()
                        .bucket(bucketName)
                        .object(fileName)
                        .contentType("application/octet-stream")
                        .stream(user.getImage().getInputStream(), user.getImage().getSize(), -1)
                        .build()
        );

        // 在这里你可以将图片信息保存到数据库，例如使用Spring Data JPA
        String url = getPresignedUrl(bucketName, fileName);
        user.setPhoto(url);
        user.setState("1");
        dao.addUser(user);

        // 返回图片的URL
        return minioClient.getPresignedObjectUrl(
                GetPresignedObjectUrlArgs.builder()
                        .bucket(bucketName)
                        .object(fileName)
                        .build()
        );
    }

    /**
     * 文件下载
     * @param fileName 文件名
     * @return
     */
    public ResponseEntity<InputStreamResource> downloadImage( String fileName){
        try {
            // 从MinIO下载文件流
            GetObjectResponse objectResponse = minioClient.getObject(
                    io.minio.GetObjectArgs.builder()
                            .bucket(bucketName)
                            .object(fileName)
                            .build()
            );

            InputStream inputStream = objectResponse;

            // 设置响应头
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
            headers.add(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE);

            // 返回响应实体
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(new InputStreamResource(inputStream));
        } catch (Exception e) {
            // 处理异常
            return ResponseEntity.notFound().build();
        }
    }


    private String getPresignedUrl(String bucketName, String objectName) throws Exception {
        return minioClient.getPresignedObjectUrl(
                GetPresignedObjectUrlArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .build()
        );
    }
}
