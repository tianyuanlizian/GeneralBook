package edu.nf.generalbook.estest;

import edu.nf.generalbook.dao.UserDao;
import edu.nf.generalbook.doc.UserDoc;
import edu.nf.generalbook.entity.User;
import edu.nf.generalbook.service.es.EsService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author：tianyuan
 * @Date：2023/12/5 15:03
 */
@SpringBootTest
@Slf4j
public class EsTest {

    @Autowired
    private EsService service;

    @Autowired
    private UserDao dao;

    @Test
    void createIndexTest(){
        service.createIndex(UserDoc.class);
    }

    @Test
    void putMappingTest(){
        service.putMapping(UserDoc.class);
    }

    /**
     * 创建文档并同步
     */
    @Test
    void createDocTest(){
        List<User> list = dao.userList();
        list.forEach(user -> {
            UserDoc doc = new UserDoc(user.getUId(), user.getName(), user.getAccount(), user.getPassword(), user.getSex(), user.getEmail(), user.getPhoto(), user.getPhone(), user.getState());
            service.createDoc(doc);
        });
    }
    @Test
    void boolSearchTest(){
        String[] fields = {"name", "account", "email", "phone"};
        List<UserDoc> list = service.boolSearch(UserDoc.class, "", fields);
        list.forEach(userDoc ->{
            log.info(userDoc.getName());
            log.info(userDoc.getAccount());
            log.info(userDoc.getPhone());
        });
    }
}
