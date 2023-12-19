package edu.nf.generalbook.service.business.impl;

import edu.nf.generalbook.dao.BusinessDao;
import edu.nf.generalbook.entity.Business;
import edu.nf.generalbook.service.business.BusinessService;
import edu.nf.generalbook.vo.PageVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/18 10:09
 **/
@Service
@Transactional(rollbackFor = RuntimeException.class)
@RequiredArgsConstructor
@Slf4j
public class BusinessServiceImpl implements BusinessService {
    private final BusinessDao dao;
    @Override
    public PageVO<List<Business>> listBusiness(Integer pageNum, Integer pageSize) {
        List<Business> list = dao.listBusiness(pageNum, pageSize);
        Long count = dao.count();
        PageVO vo = new PageVO();
        vo.setData(list);
        vo.setCount(count);
        return vo;
    }

    @Override
    public void addBusiness(Business business) {
        dao.addBusiness(business);
    }

    @Override
    public void updBusiness(Business business) {
        dao.updBusiness(business);
    }

    @Override
    public void delBusiness(Integer id) {
        dao.delBusiness(id);
    }
}
