package edu.nf.generalbook.dao;

import edu.nf.generalbook.entity.OrderGoods;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/19 19:14
 **/
public interface OrderGoodsDao {
    /**
     * 查询所有订单信息并分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<OrderGoods> listOrderGoods(Integer pageNum, Integer pageSize);

    /**
     * 添加订单
     * @param orderGoods
     */
    void addOrderGoods(OrderGoods orderGoods);

    /**
     * 根据ID删除订单
     * @param id
     */
    void delOrderGoods(Integer id);

    /**
     * 查询订单信息的总条数
     * @return
     */
    Long count();

    /**
     * 查询所有订单信息
     * @return
     */
    List<OrderGoods> orderGoodsList();
}
