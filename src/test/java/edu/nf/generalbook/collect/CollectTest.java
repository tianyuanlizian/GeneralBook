package edu.nf.generalbook.collect;

import edu.nf.generalbook.dao.CollectDao;
import edu.nf.generalbook.entity.AddressInfo;
import edu.nf.generalbook.entity.Collect;
import edu.nf.generalbook.service.collect.CollectService;
import edu.nf.generalbook.vo.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/27 15:11
 **/
@SpringBootTest
@Slf4j
public class CollectTest {
    @Autowired
    private CollectService service;
    @Autowired
    private CollectDao dao;

    @Test
    void listCollect(){
        PageVO<List<Collect>> vo = service.listCollect(1, 5);
        List<Collect> list = vo.getData();
        list.forEach(collect -> {
            log.info(collect.toString());
        });
    }
    @Test
    void addCollect(){
        Collect collect = new Collect();
        collect.setBId(1);
        collect.setCreateDate(LocalDateTime.now());
        collect.setUId(1);
        service.addCollect(collect);
    }
    @Test
    void delCollect(){
        service.delCollect(3);
    }
}
