package edu.nf.generalbook.service.notice;

import edu.nf.generalbook.entity.Notice;
import edu.nf.generalbook.entity.Types;
import edu.nf.generalbook.vo.PageVO;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/15 11:45
 **/
public interface NoticeService {
    /**
     * 发布通知
     * @param notice
     */
    void addNotice(Notice notice);

    /**
     * 根据id删除通知
     * @param id
     */
    void delNotice(Integer id);

    /**
     * 查询所有通知并分页
     * @return
     */
    PageVO<List<Notice>> listNotice(Integer pageNum, Integer pageSize);

    List<Notice> noticeList();
}
