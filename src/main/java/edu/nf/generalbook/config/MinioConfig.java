package edu.nf.generalbook.config;


import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * minio配置类
 * @Author：tianyuan
 * @Date：2023/12/7 15:23
 */
@Configuration
public class MinioConfig {
    //地址
    @Value("${minio.host}")
    private String minioHost;
    //账号
    @Value("${minio.access-key}")
    private String accessKey;
    //密码
    @Value("${minio.secret-key}")
    private String secretKey;

    //配置Minio实例
    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(minioHost)
                .credentials(accessKey, secretKey)
                .build();
    }
}