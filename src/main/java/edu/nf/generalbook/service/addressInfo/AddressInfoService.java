package edu.nf.generalbook.service.addressInfo;

import edu.nf.generalbook.entity.AddressInfo;
import edu.nf.generalbook.vo.PageVO;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/27 09:05
 **/
public interface AddressInfoService {
    PageVO<List<AddressInfo>> listAddressInfo(Integer pageNum, Integer pageSize);

    void addAddressInfo(AddressInfo addressInfo);

    void delAddressInfo(Integer id);

    void updAddressInfo(AddressInfo addressInfo);
}
