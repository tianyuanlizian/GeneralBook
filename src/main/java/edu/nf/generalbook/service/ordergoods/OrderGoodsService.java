package edu.nf.generalbook.service.ordergoods;

import edu.nf.generalbook.entity.OrderGoods;
import edu.nf.generalbook.vo.PageVO;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/25 09:44
 **/
public interface OrderGoodsService {
    PageVO<List<OrderGoods>> listOrderGoods(Integer pageNum, Integer pageSize);

    void addOrderGoods(OrderGoods orderGoods);

    void delOrderGoods(Integer id);

}
