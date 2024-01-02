package edu.nf.generalbook.controller.login;

import edu.nf.generalbook.entity.User;
import edu.nf.generalbook.service.User.UserService;
import edu.nf.generalbook.service.login.LoginService;
import edu.nf.generalbook.vo.PageVO;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: tianyuan
 * @Date: 2024/1/2 10:35
 **/
@RestController
@Slf4j
public class LoginController {
    private LoginService service;
    @Autowired
    public void setService(LoginService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public PageVO<User> login(HttpSession session, String account, String password){
        PageVO<User> user = service.login(session,account, password);
        return user;
    }
}
