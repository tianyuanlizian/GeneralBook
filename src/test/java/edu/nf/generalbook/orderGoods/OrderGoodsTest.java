package edu.nf.generalbook.orderGoods;

import edu.nf.generalbook.dao.OrderGoodsDao;
import edu.nf.generalbook.entity.OrderGoods;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/19 20:20
 **/
@SpringBootTest
@Slf4j
public class OrderGoodsTest {
    @Autowired
    private OrderGoodsDao dao;

    @Test
    void listOrderGoods(){
        List<OrderGoods> list = dao.listOrderGoods(1, 5);
        list.forEach(orderGoods -> {
            log.info(orderGoods.toString());
        });
    }
    @Test
    void addOrderGoods(){
        OrderGoods orderGoods = new OrderGoods();
        orderGoods.setOrderId("sss1101");
        orderGoods.setBId(1);
        orderGoods.setNumber(2);
        orderGoods.setUnitPrice(new BigDecimal(33.4));
        orderGoods.setTotalPrice(new BigDecimal(66.8));
        orderGoods.setMoney(new BigDecimal(66.8));
        orderGoods.setUId(1);
        orderGoods.setCreateDate(LocalDateTime.now());
        orderGoods.setState("1");
        dao.addOrderGoods(orderGoods);
    }

    @Test
    void delOrderGoods(){
        dao.delOrderGoods(3);
    }

    @Test
    void count(){
        Long count = dao.count();
        log.info(count.toString());
    }
    @Test
    void orderGoodsList(){
        List<OrderGoods> list = dao.orderGoodsList();
        list.forEach(orderGoods -> {
            log.info(orderGoods.toString());
        });
    }
}
