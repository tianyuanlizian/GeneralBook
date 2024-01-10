package edu.nf.generalBook.service.admin;

import edu.nf.generalBook.entity.Admin;
import edu.nf.generalBook.vo.PageVO;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/19 10:42
 **/
public interface AdminService {
    /**
     * 查询所有管理员信息并分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageVO<List<Admin>> listAdmin(Integer pageNum, Integer pageSize);

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

}
