package edu.nf.generalbook.service.ordergoods.impl;

import edu.nf.generalbook.dao.OrderGoodsDao;
import edu.nf.generalbook.entity.OrderGoods;
import edu.nf.generalbook.service.ordergoods.OrderGoodsService;
import edu.nf.generalbook.vo.PageVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/25 09:46
 **/
@Service
@Transactional(rollbackFor = RuntimeException.class)
@RequiredArgsConstructor
@Slf4j
public class OrderGoodsServiceImpl implements OrderGoodsService {
    private final OrderGoodsDao dao;
    @Override
    public PageVO<List<OrderGoods>> listOrderGoods(Integer pageNum, Integer pageSize) {
        PageVO vo = new PageVO();
        List<OrderGoods> list = dao.listOrderGoods(pageNum, pageSize);
        vo.setData(list);
        vo.setCount(dao.count());
        return vo;
    }

    @Override
    public void addOrderGoods(OrderGoods orderGoods) {
        dao.addOrderGoods(orderGoods);
    }

    @Override
    public void delOrderGoods(Integer id) {
        delOrderGoods(id);
    }

}
