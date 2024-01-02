package edu.nf.generalbook.service.ordergoods;

import edu.nf.generalbook.entity.OrderGoods;
import edu.nf.generalbook.vo.PageVO;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/25 09:44
 **/
public interface OrderGoodsService {
    /**
     * 查询所有订单信息并分页
     * @param pageNum 第几页
     * @param pageSize 每页多少条
     * @return
     */
    PageVO<List<OrderGoods>> listOrderGoods(Integer pageNum, Integer pageSize);

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

}
