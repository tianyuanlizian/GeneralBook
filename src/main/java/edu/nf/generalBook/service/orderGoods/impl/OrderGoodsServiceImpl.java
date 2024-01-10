package edu.nf.generalBook.service.orderGoods.impl;

import edu.nf.generalBook.dao.OrderGoodsDao;
import edu.nf.generalBook.entity.OrderGoods;
import edu.nf.generalBook.service.orderGoods.OrderGoodsService;
import edu.nf.generalBook.vo.PageVO;
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
        dao.delOrderGoods(id);
    }

    @Override
    public PageVO<List<OrderGoods>> orderGoodsListByUid(Integer uid) {
        List<OrderGoods> list = dao.orderGoodsListByUid(uid);
        PageVO vo = new PageVO();
        vo.setData(list);
        vo.setCount(list.stream().count());
        return vo;
    }

}
