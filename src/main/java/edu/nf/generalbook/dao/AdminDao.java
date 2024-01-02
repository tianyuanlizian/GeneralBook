package edu.nf.generalbook.dao;

import edu.nf.generalbook.entity.Admin;
import edu.nf.generalbook.entity.Business;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/19 09:45
 **/
public interface AdminDao {
    /**
     * 查询所有管理员信息并分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Admin> listAdmin(Integer pageNum, Integer pageSize);

    /**
     * 添加管理员
     * @param admin
     */
    void addAdmin(Admin admin);

    /**
     * 修改管理员状态
     * @param id
     * @param state
     */
    void updAdminState(Integer id, String state);
    /**
     * 根据id删除管理员
     * @param id
     */
    void delAdmin(Integer id);

    /**
     * 查询管理员总数量
     * @return
     */
    Long count();

    /**
     * 查询所有管理员信息
     * @return
     */
    List<Admin> adminList();
}
