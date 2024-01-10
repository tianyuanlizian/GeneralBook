package edu.nf.generalBook.notice;

import edu.nf.generalBook.dao.NoticeDao;
import edu.nf.generalBook.entity.Notice;
import edu.nf.generalBook.service.es.EsService;
import edu.nf.generalBook.service.notice.NoticeService;
import edu.nf.generalBook.vo.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/15 15:12
 **/
@SpringBootTest
@Slf4j
public class NoticeTest {
    @Autowired
    private NoticeService service;
    @Autowired
    private EsService esService;
    @Autowired
    private NoticeDao dao;

    @Test
    void addNotice(){
        Notice notice = new Notice();
        notice.setTitle("这是人性的扭曲，还是道德的沦丧");
        notice.setIntroduce("欢迎收看骚别传奇");
        notice.setDetails("骚别特饮（骚别粉限量版）大甩卖。。。");
        notice.setReleaseDate(LocalDate.parse("2023-12-15"));
        service.addNotice(notice);
    }

    @Test
    void delNotice(){
        service.delNotice(2);
    }

    @Test
    void listNotice(){
        PageVO<List<Notice>> vo = service.listNotice(1, 5);
        List<Notice> list = vo.getData();
        list.forEach(notice -> {
            log.info(notice.toString());
        });
    }

    @Test
    void count(){
        Long count = dao.count();
        log.info(count.toString());
    }
}
