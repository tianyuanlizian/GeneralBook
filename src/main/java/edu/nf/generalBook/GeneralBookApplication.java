package edu.nf.generalBook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "edu.nf.generalBook.dao")
public class GeneralBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeneralBookApplication.class, args);
    }

}
