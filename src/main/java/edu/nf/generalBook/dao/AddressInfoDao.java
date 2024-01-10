package edu.nf.generalBook.dao;

import edu.nf.generalBook.entity.AddressInfo;

import java.util.List;

/**
 * 地址
 * @Author: tianyuan
 * @Date: 2023/12/27 08:41
 **/
public interface AddressInfoDao {
    /**
     * 查询全部地址信息
     * @param pageNum 第几页
     * @param pageSize 每页多少条
     * @return
     */
    List<AddressInfo> listAddressInfo(Integer pageNum, Integer pageSize);

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
     * 根据ID修改
     * @param addressInfo 地址对象
     */
    void updAddressInfo(AddressInfo addressInfo);

    /**
     * 查询数据总条数
     * @return
     */
    Long count();
}
