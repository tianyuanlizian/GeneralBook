package edu.nf.generalBook.commodity;

import edu.nf.generalBook.dao.CommodityDao;
import edu.nf.generalBook.doc.CommodityDoc;
import edu.nf.generalBook.doc.UserDoc;
import edu.nf.generalBook.entity.Commodity;
import edu.nf.generalBook.service.es.EsService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author：tianyuan
 * @Date：2023/12/11 19:55
 */
@SpringBootTest
@Slf4j
public class CommodityTest {
    @Autowired
    private CommodityDao dao;
    @Autowired
    private EsService esService;

    @Test
    void listCommodityTest(){
        List<Commodity> list = dao.listCommodity(1, 5);
        list.forEach(commodity -> {
            log.info(commodity.toString());
        });
    }
    @Test
    void addCommodityTest(){
        Commodity commodity = new Commodity();
        commodity.setBName("骚鹏特饮");
        commodity.setAuthor("骚");
        commodity.setPress("sao");
        commodity.setNotes("这是骚鹏特饮");
        commodity.setTId(2);
        commodity.setIssuingDate("2020-2-20");
        commodity.setProduceDate(LocalDate.parse("2020-2-20"));
        commodity.setPicture("egdfjs");
        commodity.setInventory(110);
        commodity.setState("1");
        dao.addCommodity(commodity);
    }

    @Test
    void updCommodityTest(){
        Commodity commodity = new Commodity();
        commodity.setBId(1);
        commodity.setBName("骚bie特饮");
        commodity.setAuthor("骚");
        commodity.setPress("sao");
        commodity.setNotes("这是骚bie特饮");
        commodity.setTId(2);
        commodity.setIssuingDate("2020-2-20");
        commodity.setProduceDate(LocalDate.parse("2020-2-20"));
        commodity.setPicture("http");
        commodity.setInventory(110);
        commodity.setState("1");
        dao.updCommodity(commodity);
    }

    @Test
    void updCommodityState(){
        dao.updCommodityState(1,"0");
    }

    @Test
    void count(){
        Long count = dao.count();
        log.info(count.toString());
    }

    @Test
    void commodityListTest(){
        List<Commodity> list = dao.commodityList();
        list.forEach(commodity -> {
            log.info(commodity.toString());
        });
    }


    /**
     * 创建搜索引擎索引
     */
    @Test
    void createIndexTest(){
        esService.createIndex(CommodityDoc.class);
    }

    /**
     * 创建mapper
     */
    @Test
    void putMappingTest(){
        esService.putMapping(CommodityDoc.class);
    }

    /**
     * 创建文档并同步
     */
    @Test
    void createDocTest(){
        List<Commodity> list = dao.commodityList();
        list.forEach(commodity -> {
            CommodityDoc commodityDoc =
                    new CommodityDoc(commodity.getBId(), commodity.getBName(), commodity.getAuthor(), commodity.getPress(), commodity.getNotes(), commodity.getTypes().getName(), commodity.getIssuingDate(), commodity.getProduceDate(), commodity.getPicture(), commodity.getInventory(), commodity.getState());
            esService.createDoc(commodityDoc);
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
            log.info(userDoc.getUName());
            log.info(userDoc.getAccount());
            log.info(userDoc.getPhone());
        });
    }
}