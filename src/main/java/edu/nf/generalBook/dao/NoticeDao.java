package edu.nf.generalBook.dao;

import edu.nf.generalBook.entity.Notice;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/15 11:36
 **/
public interface NoticeDao {
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
    List<Notice> listNotice(Integer pageNum, Integer pageSize);

    /**
     * 查询通知总数量
     * @return
     */
    Long count();

    /**
     * 查询所有通知
     * @return
     */
    List<Notice> noticeList();
}
