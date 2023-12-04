package edu.nf.generalbook.controller.User;

import edu.nf.generalbook.entity.User;
import edu.nf.generalbook.service.User.UserService;
import edu.nf.generalbook.service.User.impl.UserServiceImpl;
import edu.nf.generalbook.vo.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author：tianyuan
 * @Date：2023/11/30 15:34
 */
@RestController
@Slf4j
public class LoginController {
    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public User login(String account, String password){
        User user = service.login(account, password);
        return user;
    }

    @PostMapping("/addUser")
    public void addUser(String name,String account, String password, String sex, String email, String photo, String phone){
        User user = new User();
        user.setName(name);
        user.setAccount(account);
        user.setPassword(password);
        user.setSex(sex);
        user.setEmail(email);
        user.setPhoto(photo);
        user.setPhone(phone);
        user.setState("1");
        service.addUser(user);
    }

    @GetMapping("/listUser")
    public PageVO<List<User>> listUser(Integer page, Integer limit){
        PageVO<List<User>> vo = service.listUser(page, limit);
        return vo;
    }

    @PostMapping("/updUser")
    public void updUser(Integer uid ,String name, String password, String sex, String email, String photo, String phone){
        User user = new User();
        user.setUId(uid);
        user.setName(name);
        user.setPassword(password);
        user.setSex(sex);
        user.setEmail(email);
        user.setPhoto(photo);
        user.setPhone(phone);
        service.updUser(user);
    }

}
