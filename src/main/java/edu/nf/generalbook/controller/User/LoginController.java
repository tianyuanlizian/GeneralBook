package edu.nf.generalbook.controller.User;

import edu.nf.generalbook.service.User.UserService;
import edu.nf.generalbook.service.User.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：tianyuan
 * @Date：2023/11/30 15:34
 */
@RestController
public class LoginController {
    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String login(String account, String password){
        boolean login = service.login(account, password);
        if (login){
            return "redirect:/test.html";
        }else {
            return "输入错误";
        }
    }
}
