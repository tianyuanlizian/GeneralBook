package edu.nf.generalbook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.annotations.Mapping;

@SpringBootApplication
@MapperScan(basePackages = "edu.nf.generalbook.dao")
public class GeneralBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeneralBookApplication.class, args);
    }

}
