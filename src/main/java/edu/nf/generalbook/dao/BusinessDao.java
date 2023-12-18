package edu.nf.generalbook.dao;

import edu.nf.generalbook.entity.Business;
import edu.nf.generalbook.entity.Commodity;
import edu.nf.generalbook.entity.Notice;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/18 09:29
 **/
public interface BusinessDao {
    /**
     * 查询全部商家信息并分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Business> listBusiness(Integer pageNum, Integer pageSize);

    /**
     * 添加商家信息
     * @param business
     */
    void addBusiness(Business business);

    /**
     * 修改商家信息
     * @param business
     */
    void updBusiness(Business business);
    /**
     * 根据id删除商家信息
     * @param id
     */
    void delBusiness(Integer id);

    /**
     * 查询商家信息总数量
     * @return
     */
    Long count();

    List<Business> businessList();
}
