package edu.nf.generalBook.controller.upload;

import edu.nf.generalBook.service.minio.MinioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    //Minio
    @Autowired
    private MinioService service;

//    @PostMapping("/images/upload")
//    public ResponseEntity<String> uploadImage(   @RequestParam String name,
//                                                 @RequestParam String account,
//                                                 @RequestParam String password,
//                                                 @RequestParam String sex,
//                                                 @RequestParam String email,
//                                                 @RequestParam String phone,
//                                                 @RequestParam MultipartFile image) {
//        try {
//            User user = new User();
//            user.setName(name);
//            user.setAccount(account);
//            user.setPassword(password);
//            user.setSex(sex);
//            user.setEmail(email);
//            user.setPhone(phone);
//            user.setImage(image);
//            service.uploadImage(user);
//            return ResponseEntity.ok("成功上传");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading image");
//        }
//    }


    //使用Minio上传图片
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String fileUrl = service.uploadFile(file);

        return ResponseEntity.ok(fileUrl);
    }
}
