package edu.nf.generalbook.usertest;

import edu.nf.generalbook.dao.UserDao;
import edu.nf.generalbook.entity.User;
import edu.nf.generalbook.service.User.UserService;
import edu.nf.generalbook.vo.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author：tianyuan
 * @Date：2023/11/30 11:46
 */
@SpringBootTest
@Slf4j
public class UserTest {

    @Autowired
    private UserService service;

    @Test
    void addTest(){
        User user = new User();
        user.setName("测试");
        user.setAccount("12123124");
        user.setPassword("123456");
        user.setSex("男");
        user.setEmail("4690590312@qq.com");
        user.setPhoto("34444444545");
        user.setPhone("564736743712");
        user.setState("1");
        service.addUser(user);
    }

    @Test
    void updTest(){
        User user = new User();
        user.setUId(1);
        user.setName("骚别");
        user.setAccount("12123124");
        user.setPassword("qin123");
        user.setSex("男");
        user.setEmail("2562346723@qq.com");
        user.setPhoto("3r8265rduiwh");
        user.setPhone("18870148284");
        user.setState("1");
        service.updUser(user);
    }
    @Test
    void updState(){
        service.updUserState(1,"0");
    }

    @Test
    void listUser(){
        PageVO<List<User>> vo = service.listUser(1, 10);
        List<User> list = vo.getData();
        list.forEach(user -> {
            log.info(user.toString());
        });
    }
    @Test
    void countTest(){
        PageVO<List<User>> vo = service.listUser(1, 10);
        Long count = vo.getCount();
        log.info(count.toString());
    }
}
