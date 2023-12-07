package edu.nf.generalbook.config;


import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author：tianyuan
 * @Date：2023/12/7 15:23
 */
@Configuration
public class MinioConfig {

    @Value("${minio.host}")
    private String minioHost;

    @Value("${minio.access-key}")
    private String accessKey;

    @Value("${minio.secret-key}")
    private String secretKey;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(minioHost)
                .credentials(accessKey, secretKey)
                .build();
    }
}