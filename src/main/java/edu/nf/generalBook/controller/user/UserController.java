package edu.nf.generalBook.controller.user;

import edu.nf.generalBook.doc.UserDoc;
import edu.nf.generalBook.entity.User;
import edu.nf.generalBook.service.User.UserService;
import edu.nf.generalBook.service.es.EsService;
import edu.nf.generalBook.vo.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author：tianyuan
 * @Date：2023/11/30 15:34
 */
@RestController
@Slf4j
public class UserController {
    //用户的service
    private UserService service;
    //搜索引擎
    private EsService esService;
    //注入
    @Autowired
    public void setEsService(EsService esService) {
        this.esService = esService;
    }

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }
    //注册新用户
    @PostMapping("/addUser")
    public void addUser(String uname,String account, String password, String sex, String email, String photo, String phone){
        User user = new User();
        user.setUName(uname);
        user.setAccount(account);
        user.setPassword(password);
        user.setSex(sex);
        user.setEmail(email);
        user.setPhoto(photo);
        user.setPhone(phone);
        user.setState("1");
        service.addUser(user);
    }
    //查询全部的用户信息
    @GetMapping("/listUser")
    public PageVO<List<User>> listUser(Integer page, Integer limit){
        PageVO<List<User>> vo = service.listUser(page, limit);
        return vo;
    }
    //根据ID修改用户信息
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
    //根据ID修改用户状态
    @GetMapping("/updState")
    public void updState(Integer uid,String state){
        service.updUserState(uid,state);
    }

    //使用搜索引擎查询用户信息
    @GetMapping("/selectUser")
    public PageVO<List<UserDoc>> selectUser(String param, Integer page, Integer limit){
        String[] fields = {"uName", "account", "email", "phone"};
        List<UserDoc> list = esService.boolSearch(UserDoc.class, param, fields);
        PageVO vo = new PageVO();
        vo.setData(list);
        vo.setCount(list.stream().count());
        return vo;
    }
    @PostMapping("/appRegister")
    public PageVO appRegister(@RequestBody Map<String, String> register){
        User user = new User();
        user.setUName(register.get("name"));
        user.setAccount(register.get("account"));
        user.setPassword(register.get("password"));
        user.setSex(register.get("sex"));
        user.setEmail(register.get("email"));
        user.setPhoto(register.get("photo"));
        user.setPhone(register.get("phone"));
        user.setState("1");
        service.addUser(user);
        PageVO vo = new PageVO();
        vo.setMessage("注册成功");
        vo.setCode(200);
        return vo;
    }
}
