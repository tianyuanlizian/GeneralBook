package edu.nf.generalBook.service.minio.impl;

import edu.nf.generalBook.dao.UserDao;
import edu.nf.generalBook.service.minio.MinioService;
import io.minio.*;
import io.minio.errors.MinioException;
import io.minio.http.Method;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
     * 上存图片并返回图片地址
     * @param file
     * @return
     */
    public String uploadFile(MultipartFile file) {
        try {
            // 生成唯一文件名
            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

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
