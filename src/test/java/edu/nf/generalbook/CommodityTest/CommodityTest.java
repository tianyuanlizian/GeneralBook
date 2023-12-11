package edu.nf.generalbook.CommodityTest;

import edu.nf.generalbook.dao.CommodityDao;
import edu.nf.generalbook.entity.Commodity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
