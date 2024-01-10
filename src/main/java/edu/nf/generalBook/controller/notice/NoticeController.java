package edu.nf.generalBook.controller.notice;

import edu.nf.generalBook.doc.NoticeDoc;
import edu.nf.generalBook.entity.Notice;
import edu.nf.generalBook.service.es.EsService;
import edu.nf.generalBook.service.notice.NoticeService;
import edu.nf.generalBook.vo.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author：tianyuan
 * @Date：2023/12/11 9:44
 */
@RestController
@Slf4j
public class NoticeController {
    //通知功能的service
    private NoticeService service;
    //搜索引擎
    private EsService esService;
    //注入
    @Autowired
    public void setService(NoticeService service) {
        this.service = service;
    }
    @Autowired
    public void setEsService(EsService esService) {
        this.esService = esService;
    }
    //查询全部的通知
    @GetMapping("/listNotice")
    public PageVO<List<Notice>> listNotice(Integer page, Integer limit){
        PageVO<List<Notice>> vo = service.listNotice(page, limit);
        return vo;
    }
    //发布一条新通知
    @PostMapping("/addNotice")
    public void addNotice(String title, String introduce, String details, String releaseDate){
        Notice notice = new Notice();
        notice.setTitle(title);
        notice.setIntroduce(introduce);
        notice.setDetails(details);
        notice.setReleaseDate(LocalDate.parse(releaseDate));
        service.addNotice(notice);
    }
    //根据ID删除通知
    @PostMapping("/delNotice")
    public void delNotice(Integer nid){
        service.delNotice(nid);
    }
    //使用搜索引擎查询数据
    @GetMapping("/selectNotice")
    public PageVO<List<Notice>> selectNotice(String param, Integer page, Integer limit){
        String[] fields = {"name"};
        List<NoticeDoc> list = esService.boolSearch(NoticeDoc.class, param, fields);
        PageVO vo = new PageVO();
        vo.setData(list);
        vo.setCount(list.stream().count());
        return vo;
    }
    //查询全部的通知（不使用分页）
    @GetMapping("/NoticeList")
    public PageVO<List<Notice>> NoticeList(){
        List<Notice> list = service.noticeList();
        PageVO vo = new PageVO();
        vo.setData(list);
        return vo;
    }
}
