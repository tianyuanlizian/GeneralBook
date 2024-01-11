package edu.nf.generalBook.service.shoppingCart;

import edu.nf.generalBook.entity.ShoppingCart;
import edu.nf.generalBook.vo.PageVO;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2024/1/10 20:24
 **/
public interface ShoppingCartService {
    //添加到购物车一件商品
    PageVO addShoppingCart(Integer uid, Integer bid);

    //根据用户Id查询购物车
    PageVO<List<ShoppingCart>> listShoppingCartById(Integer uid, Integer pageNum, Integer pageSize);

    //删除购物车里的商品
    void delShoppingCart(Integer uid, Integer bid);
    //修改购物车中商品的数量
    void updShoppingCart(Integer uid, Integer bid, Integer num);
    ShoppingCart getShoppingCartById(Integer uid, Integer bid);
}
