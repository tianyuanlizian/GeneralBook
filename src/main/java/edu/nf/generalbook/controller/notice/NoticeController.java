package edu.nf.generalbook.controller.notice;

import edu.nf.generalbook.doc.NoticeDoc;
import edu.nf.generalbook.doc.TypesDoc;
import edu.nf.generalbook.doc.UserDoc;
import edu.nf.generalbook.entity.Notice;
import edu.nf.generalbook.entity.Types;
import edu.nf.generalbook.service.es.EsService;
import edu.nf.generalbook.service.notice.NoticeService;
import edu.nf.generalbook.service.types.TypesService;
import edu.nf.generalbook.vo.PageVO;
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

    private NoticeService service;
    private EsService esService;
    @Autowired
    public void setService(NoticeService service) {
        this.service = service;
    }
    @Autowired
    public void setEsService(EsService esService) {
        this.esService = esService;
    }

    @GetMapping("/listNotice")
    public PageVO<List<Notice>> listNotice(Integer page, Integer limit){
        PageVO<List<Notice>> vo = service.listNotice(page, limit);
        return vo;
    }

    @PostMapping("/addNotice")
    public void addNotice(String title, String introduce, String details, String releaseDate){
        Notice notice = new Notice();
        notice.setTitle(title);
        notice.setIntroduce(introduce);
        notice.setDetails(details);
        notice.setReleaseDate(LocalDate.parse(releaseDate));
        service.addNotice(notice);
    }

    @PostMapping("/delNotice")
    public void delNotice(Integer nid){
        service.delNotice(nid);
    }

    @GetMapping("/selectNotice")
    public PageVO<List<Notice>> selectNotice(String param, Integer page, Integer limit){
        String[] fields = {"name"};
        List<NoticeDoc> list = esService.boolSearch(NoticeDoc.class, param, fields);
        PageVO vo = new PageVO();
        vo.setData(list);
        vo.setCount(list.stream().count());
        return vo;
    }
    @GetMapping("/NoticeList")
    public PageVO<List<Notice>> NoticeList(){
        List<Notice> list = service.noticeList();
        PageVO vo = new PageVO();
        vo.setData(list);
        return vo;
    }
}
