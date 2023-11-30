package edu.nf.generalbook.UserTest;

import edu.nf.generalbook.dao.UserDao;
import edu.nf.generalbook.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author：tianyuan
 * @Date：2023/11/30 11:46
 */
@SpringBootTest
@Slf4j
public class UserTest {

    @Autowired
    private UserDao dao;

    @Test
    void addTest(){
        User user = new User();
        user.setName("骚别");
        user.setAccount("12123124");
        user.setPassword("qin123");
        user.setSex("男");
        user.setEmail("2562346723@qq.com");
        user.setPhoto("3r8265rduiwh");
        user.setPhone("131423545");
        user.setState("1");
        dao.addUser(user);
    }
}
