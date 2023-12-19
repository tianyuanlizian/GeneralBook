package edu.nf.generalbook.dao;

import edu.nf.generalbook.entity.OrderGoods;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/19 19:14
 **/
public interface OrderGoodsDao {
    List<OrderGoods> listOrderGoods(Integer pageNum, Integer pageSize);

    void addOrderGoods(OrderGoods orderGoods);

    void delOrderGoods(Integer id);

    Long count();

    List<OrderGoods> orderGoodsList();
}
