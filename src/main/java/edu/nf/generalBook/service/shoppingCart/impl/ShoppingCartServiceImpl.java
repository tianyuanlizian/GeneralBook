package edu.nf.generalBook.service.shoppingCart.impl;

import edu.nf.generalBook.dao.ShoppingCartDao;
import edu.nf.generalBook.entity.ShoppingCart;
import edu.nf.generalBook.service.shoppingCart.ShoppingCartService;
import edu.nf.generalBook.vo.PageVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2024/1/10 20:26
 **/
@Service
@Transactional(rollbackFor = RuntimeException.class)
@RequiredArgsConstructor
@Slf4j
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartDao dao;
    @Override
    public PageVO addShoppingCart(Integer uid, Integer bid) {
        PageVO vo = new PageVO();
        ShoppingCart cart = dao.getShoppingCartById(uid, bid);
        if (cart != null){
            Integer num = cart.getNum()+1;
            dao.updShoppingCart(uid,bid,num);
            vo.setCode(201);
        }else{
            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.setUId(uid);
            shoppingCart.setBId(bid);
            shoppingCart.setNum(1);
            dao.addShoppingCart(shoppingCart);
            vo.setCode(200);
            vo.setData(dao.getShoppingCartById(uid, bid));
        }
        return vo;
    }

    @Override
    public PageVO<List<ShoppingCart>> listShoppingCartById(Integer uid, Integer pageNum, Integer pageSize) {
        List<ShoppingCart> list = dao.listShoppingCartById(uid, pageNum, pageSize);
        PageVO vo = new PageVO();
        vo.setData(list);
        vo.setCount(list.stream().count());
        return vo;
    }

    @Override
    public void delShoppingCart(Integer uid, Integer bid) {
        dao.delShoppingCart(uid, bid);
    }

    @Override
    public void updShoppingCart(Integer uid, Integer bid, Integer num) {
        dao.updShoppingCart(uid, bid, num);
    }

    @Override
    public ShoppingCart getShoppingCartById(Integer uid, Integer bid) {
        ShoppingCart shoppingCart = dao.getShoppingCartById(uid, bid);
        return shoppingCart;
    }
}
