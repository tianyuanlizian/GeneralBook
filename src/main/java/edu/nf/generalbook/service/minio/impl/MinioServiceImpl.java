package edu.nf.generalbook.service.minio.impl;

import edu.nf.generalbook.dao.UserDao;
import edu.nf.generalbook.entity.User;
import edu.nf.generalbook.service.minio.MinioService;
import io.minio.*;
import io.minio.errors.MinioException;
import io.minio.http.Method;
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
import org.springframework.web.multipart.MultipartFile;

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
public class MinioServiceImpl implements MinioService {

    @Autowired
    private  MinioClient minioClient;

    private final UserDao dao;

    private String bucketName = "user";
    /**
     * 创建桶
     * @param bucketName
     */
    public  void createBucket(String bucketName) throws Exception{
        //先判断同是否存在，不存在则创建
        if(!minioClient.bucketExists(BucketExistsArgs.builder()
                .bucket(bucketName).build())) {
            minioClient.makeBucket(MakeBucketArgs.builder()
                    .bucket(bucketName).build());
        }
    }

    /**
     * 上存图片并保存信息
     * @return
     */
    public void uploadImage(User user) throws Exception {
        createBucket(bucketName);
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

        // 在这里你可以将图片信息保存到数据库
        //获取链接
        String url = getPresignedUrl(bucketName, fileName);
        user.setPhoto(url);
        user.setState("1");
        dao.addUser(user);
    }

    /**
     * 上存图片
     * @param file
     * @return
     */
    public String uploadFile(MultipartFile file) {
        try {
            // 生成唯一文件名
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

            // 使用MinioClient上传文件
            minioClient.putObject(
                    io.minio.PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(fileName)
                            .contentType("application/octet-stream")
                            .stream(file.getInputStream(), file.getSize(), -1)
                            .build()
            );

            // 返回文件访问路径
            return getPresignedUrl(bucketName,fileName);
        } catch (Exception e) {
            throw new RuntimeException("Failed to upload file", e);
        }
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

    /**
     * 返回下载链接
     * @param bucketName
     * @param objectName
     * @return
     * @throws Exception
     */
    private String getPresignedUrl(String bucketName, String objectName) throws Exception {
        try {
            String uploadUrl = minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .method(Method.GET)
                            .bucket(bucketName)
                            .object(objectName)
                            .build()
            );
            // 使用 indexOf 寻找问号的位置
            int indexOfQuestionMark = uploadUrl.indexOf('?');

            // 如果找到问号，截取字符串
            String url = (indexOfQuestionMark != -1) ? uploadUrl.substring(0, indexOfQuestionMark) : uploadUrl;

            return url;
        } catch (MinioException e) {
            throw new Exception("Error generating presigned URL", e);
        }
    }
}
