package edu.nf.generalbook.dao;

import edu.nf.generalbook.entity.Notice;
import edu.nf.generalbook.entity.Types;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/15 11:36
 **/
public interface NoticeDao {
    /**
     * 发布通知
     * @param name
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
    List<Notice> listNotice(Integer pageNum, Integer pageSize);

    /**
     * 查询通知总数量
     * @return
     */
    Long count();

    List<Notice> noticeList();
}
