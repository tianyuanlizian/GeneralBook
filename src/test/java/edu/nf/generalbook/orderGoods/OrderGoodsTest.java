package edu.nf.generalbook.orderGoods;

import edu.nf.generalbook.dao.OrderGoodsDao;
import edu.nf.generalbook.entity.OrderGoods;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
