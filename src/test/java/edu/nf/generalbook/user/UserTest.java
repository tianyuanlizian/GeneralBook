package edu.nf.generalbook.user;

import edu.nf.generalbook.dao.UserDao;
import edu.nf.generalbook.doc.UserDoc;
import edu.nf.generalbook.entity.User;
import edu.nf.generalbook.service.User.UserService;
import edu.nf.generalbook.service.es.EsService;
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
    @Autowired
    private UserDao dao;
    @Autowired
    private EsService esService;

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
        PageVO<List<User>> vo = service.listUser(1, 5);
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

    /**
     * 创建搜索引擎索引
     */
    @Test
    void createIndexTest(){
        esService.createIndex(UserDoc.class);
    }

    /**
     * 创建mapper
     */
    @Test
    void putMappingTest(){
        esService.putMapping(UserDoc.class);
    }

    /**
     * 创建文档并同步
     */
    @Test
    void createDocTest(){
        List<User> list = dao.userList();
        list.forEach(user -> {
            UserDoc doc = new UserDoc(user.getUId(), user.getName(), user.getAccount(), user.getPassword(), user.getSex(), user.getEmail(), user.getPhoto(), user.getPhone(), user.getState());
            esService.createDoc(doc);
        });
    }

    /**
     * 布隆查询
     */
    @Test
    void boolSearchTest(){
        String[] fields = {"name", "account", "email", "phone"};
        List<UserDoc> list = esService.boolSearch(UserDoc.class, "测试", fields);
        list.forEach(userDoc ->{
            log.info(userDoc.getName());
            log.info(userDoc.getAccount());
            log.info(userDoc.getPhone());
        });
    }
}
