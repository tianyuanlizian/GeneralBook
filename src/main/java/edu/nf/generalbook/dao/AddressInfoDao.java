package edu.nf.generalbook.dao;

import edu.nf.generalbook.entity.AddressInfo;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/27 08:41
 **/
public interface AddressInfoDao {
    List<AddressInfo> listAddressInfo(Integer pageNum, Integer pageSize);

    void addAddressInfo(AddressInfo addressInfo);

    void delAddressInfo(Integer id);

    void updAddressInfo(AddressInfo addressInfo);

    Long count();
}
