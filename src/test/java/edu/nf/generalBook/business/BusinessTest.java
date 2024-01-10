package edu.nf.generalBook.business;

import edu.nf.generalBook.dao.BusinessDao;
import edu.nf.generalBook.entity.Business;
import edu.nf.generalBook.service.business.BusinessService;
import edu.nf.generalBook.service.es.EsService;
import edu.nf.generalBook.vo.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/18 10:40
 **/
@SpringBootTest
@Slf4j
public class BusinessTest {
    @Autowired
    private BusinessService service;
    @Autowired
    private EsService esService;
    @Autowired
    private BusinessDao dao;

    @Test
    void addBusiness(){
        Business business = new Business();
        business.setBuName("珠海总店");
        business.setAddress("珠海斗门区");
        business.setPhone("1212432");
        business.setEmail("12343243@qq.com");
        business.setPicture("http");
        business.setIntroduce("本店于1998年正式创建，选用骚别的现象作为吉祥物");
        service.addBusiness(business);
    }

    @Test
    void updBusiness(){
        Business business = new Business();
        business.setBuId(2);
        business.setBuName("美国分店");
        business.setAddress("白宫");
        business.setPhone("1221432");
        business.setEmail("68678673@qq.com");
        business.setPicture("http");
        business.setIntroduce("派遣阿骚成为高级特工，代号“骚别粉");
        service.updBusiness(business);
    }

    @Test
    void delBusiness(){
        service.delBusiness(3);
    }

    @Test
    void listBusiness(){
        PageVO<List<Business>> vo = service.listBusiness(1, 5);
        List<Business> list = vo.getData();
        list.forEach(business -> {
            log.info(business.toString());
        });
    }
    @Test
    void count(){
        Long count = dao.count();
        log.info(count.toString());
    }
}
