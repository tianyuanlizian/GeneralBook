package edu.nf.generalbook.CommodityTest;

import edu.nf.generalbook.dao.CommodityDao;
import edu.nf.generalbook.entity.Commodity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;
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
        commodity.setProduceDate(java.sql.Date.valueOf("2020-2-20"));
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
        commodity.setProduceDate(new Date("2020-2-20"));
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
}