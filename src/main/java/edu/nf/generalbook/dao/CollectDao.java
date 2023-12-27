package edu.nf.generalbook.dao;

import edu.nf.generalbook.entity.AddressInfo;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/27 09:57
 **/
public interface CollectDao {
    List<AddressInfo> listAddressInfo(Integer pageNum, Integer pageSize);

    void addAddressInfo(AddressInfo addressInfo);

    void delAddressInfo(Integer id);

    Long count();
}
