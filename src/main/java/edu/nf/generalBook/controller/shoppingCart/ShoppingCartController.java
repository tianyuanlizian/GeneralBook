package edu.nf.generalBook.controller.shoppingCart;

import edu.nf.generalBook.dao.ShoppingCartDao;
import edu.nf.generalBook.entity.ShoppingCart;
import edu.nf.generalBook.service.orderGoods.OrderGoodsService;
import edu.nf.generalBook.service.shoppingCart.ShoppingCartService;
import edu.nf.generalBook.vo.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: tianyuan
 * @Date: 2024/1/10 20:34
 **/
@RestController
@Slf4j
public class ShoppingCartController {
    private ShoppingCartService service;
    @Autowired
    public void setService(ShoppingCartService service) {
        this.service = service;
    }
    //添加到购物车一件商品
    @PostMapping("/addShoppingCart")
    private void addShoppingCart(@RequestBody Map<String,Integer> shoppingCart){
        service.addShoppingCart();
    }
    //根据用户Id查询购物车
    @GetMapping("/listShoppingCartById")
    private PageVO<List<ShoppingCart>> listShoppingCartById(Integer uid, Integer pageNum, Integer pageSize){

    }

    //删除购物车里的商品
    @PostMapping("/delShoppingCart")
    private void delShoppingCart(Integer uid, Integer bid){

    }
    //修改购物车中商品的数量
    @PostMapping("/updShoppingCart")
    private void updShoppingCart(Integer uid, Integer bid, Integer num){

    }
}
