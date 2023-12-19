package edu.nf.generalbook.admin;

import edu.nf.generalbook.dao.AdminDao;
import edu.nf.generalbook.entity.Admin;
import edu.nf.generalbook.service.admin.AdminService;
import edu.nf.generalbook.service.es.EsService;
import edu.nf.generalbook.vo.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/19 10:51
 **/
@SpringBootTest
@Slf4j
public class AdminTest {
    @Autowired
    private AdminService service;
    @Autowired
    private EsService esService;
    @Autowired
    private AdminDao dao;

    @Test
    void listAdmin(){
        PageVO<List<Admin>> vo = service.listAdmin(1, 5);
        List<Admin> data = vo.getData();
        data.forEach(admin -> {
            log.info(admin.toString());
        });
    }
    @Test
    void addAdmin(){
        Admin admin = new Admin();
        admin.setAdName("admin");
        admin.setAccount("admin2");
        admin.setPassword("admin2");
        admin.setState("1");
        service.addAdmin(admin);
    }
    @Test
    void updAdminState(){
        service.updAdminState(2,"0");
    }

    @Test
    void delAdmin(){
        service.delAdmin(2);
    }

    @Test
    void count(){
        Long count = dao.count();
        log.info(count.toString());
    }
}
