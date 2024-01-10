package edu.nf.generalBook.service.addressInfo;

import edu.nf.generalBook.entity.AddressInfo;
import edu.nf.generalBook.vo.PageVO;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/27 09:05
 **/
public interface AddressInfoService {
    /**
     * 查询全部地址信息
     * @param pageNum 第几页
     * @param pageSize 每页多少条
     * @return
     */
    PageVO<List<AddressInfo>> listAddressInfo(Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param addressInfo 地址对象
     */
    void addAddressInfo(AddressInfo addressInfo);

    /**
     * 根据ID删除
     * @param id
     */
    void delAddressInfo(Integer id);

    /**
     * 根据Id修改
     * @param addressInfo 地址对象
     */
    void updAddressInfo(AddressInfo addressInfo);
}
