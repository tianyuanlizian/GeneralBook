package edu.nf.generalBook.dao;

import edu.nf.generalBook.entity.ShoppingCart;

import java.util.List;

/**
 * 购物车dao层
 * @Author: tianyuan
 * @Date: 2024/1/10 16:13
 **/
public interface ShoppingCartDao {

    //添加到购物车一件商品
    void addShoppingCart(ShoppingCart shoppingCart);

    //根据用户Id查询购物车
    List<ShoppingCart> listShoppingCartById(Integer uid, Integer pageNum, Integer pageSize);

    //删除购物车里的商品
    void delShoppingCart(Integer uid, Integer bid);
    //修改购物车中商品的数量
    void updShoppingCart(Integer uid, Integer bid, Integer num);
}
