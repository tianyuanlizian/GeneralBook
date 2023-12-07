package edu.nf.generalbook.controller.upload;

import edu.nf.generalbook.entity.User;
import edu.nf.generalbook.service.minio.impl.MinioServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author：tianyuan
 * @Date：2023/12/7 10:36
 */
@RestController
@Slf4j
public class MinioController {
    @Autowired
    private MinioServiceImpl service;

    @PostMapping("/images/upload")
    public ResponseEntity<String> uploadImage(   @RequestParam String name,
                                                 @RequestParam String account,
                                                 @RequestParam String password,
                                                 @RequestParam String sex,
                                                 @RequestParam String email,
                                                 @RequestParam String phone,
                                                 @RequestParam MultipartFile image) {
        try {
            User user = new User(name, account, password, sex, email, phone,image);
            String imageUrl = service.uploadImage(user);
            return ResponseEntity.ok(imageUrl);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading image");
        }
    }
}
