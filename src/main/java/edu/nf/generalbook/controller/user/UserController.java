package edu.nf.generalbook.controller.user;

import edu.nf.generalbook.doc.UserDoc;
import edu.nf.generalbook.entity.User;
import edu.nf.generalbook.service.User.UserService;
import edu.nf.generalbook.service.es.EsService;
import edu.nf.generalbook.vo.PageVO;
import jakarta.servlet.http.HttpSession;
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
public class UserController {
    private UserService service;

    private EsService esService;

    @Autowired
    public void setEsService(EsService esService) {
        this.esService = esService;
    }

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @PostMapping("/addUser")
    public void addUser(String uname,String account, String password, String sex, String email, String image, String phone){
        User user = new User();
        user.setUName(uname);
        user.setAccount(account);
        user.setPassword(password);
        user.setSex(sex);
        user.setEmail(email);
        user.setPhoto(image);
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
    public void updUser(Integer uid ,String uname, String account, String password, String sex, String email, String image, String phone){
        User user = new User();
        user.setUId(uid);
        user.setUName(uname);
        user.setAccount(account);
        user.setPassword(password);
        user.setSex(sex);
        user.setEmail(email);
        user.setPhoto(image);
        user.setPhone(phone);
        service.updUser(user);
    }

    @GetMapping("/updState")
    public void updState(Integer uid,String state){
        service.updUserState(uid,state);
    }


    @GetMapping("/selectUser")
    public PageVO<List<UserDoc>> selectUser(String param, Integer page, Integer limit){
        String[] fields = {"name", "account", "email", "phone"};
        List<UserDoc> list = esService.boolSearch(UserDoc.class, param, fields);
        PageVO vo = new PageVO();
        vo.setData(list);
        vo.setCount(list.stream().count());
        return vo;
    }
}
