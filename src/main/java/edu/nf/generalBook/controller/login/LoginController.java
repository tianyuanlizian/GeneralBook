package edu.nf.generalBook.controller.login;

import edu.nf.generalBook.entity.User;
import edu.nf.generalBook.service.login.LoginService;
import edu.nf.generalBook.vo.PageVO;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: tianyuan
 * @Date: 2024/1/2 10:35
 **/
@RestController
@Slf4j
public class LoginController {
    //登录功能的service
    private LoginService service;
    //注入
    @Autowired
    public void setService(LoginService service) {
        this.service = service;
    }

    //登录
    @PostMapping("/login")
    public PageVO<User> login(HttpSession session, String account, String password){
        PageVO<User> user = service.login(session,account, password);
        return user;
    }
    @PostMapping("/appLogin")
    public PageVO<User> appLogin(HttpSession session, @RequestBody Map<String, String> loginData) {
        String account = loginData.get("account");
        String password = loginData.get("password");

        PageVO<User> user = service.login(session, account, password);
        return user;
    }
}
