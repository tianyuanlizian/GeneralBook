package edu.nf.generalBook.service.addressInfo.impl;

import edu.nf.generalBook.dao.AddressInfoDao;
import edu.nf.generalBook.entity.AddressInfo;
import edu.nf.generalBook.service.addressInfo.AddressInfoService;
import edu.nf.generalBook.vo.PageVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/27 09:06
 **/
@Slf4j
@Transactional(rollbackFor = RuntimeException.class)
@RequiredArgsConstructor
@Service
public class AddressInfoServiceImpl implements AddressInfoService {
    private final AddressInfoDao dao;
    @Override
    public PageVO<List<AddressInfo>> listAddressInfo(Integer pageNum, Integer pageSize) {
        List<AddressInfo> list = dao.listAddressInfo(pageNum, pageSize);
        Long count = dao.count();
        PageVO vo = new PageVO();
        vo.setData(list);
        vo.setCount(count);
        return vo;
    }

    @Override
    public void addAddressInfo(AddressInfo addressInfo) {
        dao.addAddressInfo(addressInfo);
    }

    @Override
    public void delAddressInfo(Integer id) {
        dao.delAddressInfo(id);
    }

    @Override
    public void updAddressInfo(AddressInfo addressInfo) {
        dao.updAddressInfo(addressInfo);
    }
}
