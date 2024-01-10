package edu.nf.generalBook.service.business;

import edu.nf.generalBook.entity.Business;
import edu.nf.generalBook.vo.PageVO;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/18 10:06
 **/
public interface BusinessService {
    /**
     * 查询全部商家信息并分页
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageVO<List<Business>> listBusiness(Integer pageNum, Integer pageSize);

    /**
     * 添加商家信息
     *
     * @param business
     */
    void addBusiness(Business business);

    /**
     * 修改商家信息
     *
     * @param business
     */
    void updBusiness(Business business);

    /**
     * 根据id删除商家信息
     *
     * @param id
     */
    void delBusiness(Integer id);


}
