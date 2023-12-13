package edu.nf.generalbook.service.commodity.impl;

import edu.nf.generalbook.dao.CommodityDao;
import edu.nf.generalbook.entity.Commodity;
import edu.nf.generalbook.service.commodity.CommodityService;
import edu.nf.generalbook.vo.PageVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author：tianyuan
 * @Date：2023/12/11 19:17
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
@RequiredArgsConstructor
@Slf4j
public class CommodityServiceImpl implements CommodityService {
    private final CommodityDao dao;
    @Override
    public PageVO<List<Commodity>> listCommodity(Integer pageNum, Integer pageSize) {
        List<Commodity> list = dao.listCommodity(pageNum, pageSize);
        Long count = dao.count();
        PageVO vo = new PageVO();
        vo.setData(list);
        vo.setCount(count);
        return vo;
    }

    @Override
    public void addCommodity(Commodity commodity) {
        dao.addCommodity(commodity);
    }

    @Override
    public void updCommodity(Commodity commodity) {
        dao.updCommodity(commodity);
    }

    @Override
    public void updCommodityState(Integer bId, String state) {
        dao.updCommodityState(bId, state);
    }
}
