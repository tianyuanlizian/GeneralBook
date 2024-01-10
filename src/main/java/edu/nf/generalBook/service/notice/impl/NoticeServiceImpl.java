package edu.nf.generalBook.service.notice.impl;

import edu.nf.generalBook.dao.NoticeDao;
import edu.nf.generalBook.entity.Notice;
import edu.nf.generalBook.service.notice.NoticeService;
import edu.nf.generalBook.vo.PageVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/15 11:46
 **/
@Service
@Transactional(rollbackFor = RuntimeException.class)
@RequiredArgsConstructor
@Slf4j
public class NoticeServiceImpl implements NoticeService {

    private final NoticeDao dao;

    @Override
    public void addNotice(Notice notice) {
        dao.addNotice(notice);
    }

    @Override
    public void delNotice(Integer id) {
        dao.delNotice(id);
    }

    @Override
    public PageVO<List<Notice>> listNotice(Integer pageNum, Integer pageSize) {
        List<Notice> list = dao.listNotice(pageNum, pageSize);
        Long count = dao.count();
        PageVO vo = new PageVO();
        vo.setData(list);
        vo.setCount(count);
        return vo;
    }

    @Override
    public List<Notice> noticeList() {
        List<Notice> list = dao.noticeList();
        return list;
    }
}
