package edu.nf.generalbook.service.minio.impl;

import edu.nf.generalbook.entity.User;
import io.minio.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * @Author：tianyuan
 * @Date：2023/12/6 20:26
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MinioServiceImpl {

    private static MinioClient minioClient;
    @Autowired
    public static void setMinioClient(MinioClient minioClient) {
        MinioServiceImpl.minioClient = minioClient;
    }

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

    public User add(User user) throws IOException {
//        User vo = new User();
//        //获取上传的路径(绝对路径)
//        String uploadPath = "/Users/wangl/files/";
//        log.info(uploadPath);
//        //根据路径构建上传的文件对象
//        File uploadFile = new File(uploadPath);
//        //判断路径中的文件夹是否存在，不存在则创建出来
//        if(!uploadFile.exists()) {
//            //将文件夹创建出来
//            uploadFile.mkdirs();
//        }
//        //获取所有上传的附件
//        MultipartFile[] files = productVO.getFile();
//        //循环遍历
//        for(MultipartFile file : files) {
//            //获取文件名
//            String fileName = file.getOriginalFilename();
//            //执行上传
//            Path path = FileSystems.getDefault()
//                    .getPath(uploadFile.getAbsolutePath(), fileName);
//            file.transferTo(path);
//        }
        return user;
    }

    /**
     * 文件下载
     * @param fileName
     * @return
     */
    public ResponseEntity<InputStreamResource> download(
            @PathVariable("fileName") String fileName) throws Exception {
        //文件下载路径（也是上传路径）
        String downloadPath = "/Users/wangl/files/" + fileName;
        //构建一个文件输入流读取服务器上的文件
        FileInputStream fis = new FileInputStream(downloadPath);
        //设置响应头，告诉浏览器响应流数据
        HttpHeaders headers = new HttpHeaders();
        //对文件名进行编码，防止在响应头中出现乱码
        fileName = URLEncoder.encode(fileName, "UTF-8");
        //设置头信息，将响应内容处理的方式设置为附件下载
        headers.setContentDispositionFormData("attachment", fileName);
        //设置响应类型为流类型
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //创建InputStreamResource对象封装输入流，用于读取服务器文件
        InputStreamResource isr = new InputStreamResource(fis);
        //创建ResponseEntity对象（封装InputStreamResource、响应头、响应状态码）
        ResponseEntity<InputStreamResource> entity =
                new ResponseEntity<>(isr, headers, HttpStatus.CREATED);
        return entity;

    }
}
