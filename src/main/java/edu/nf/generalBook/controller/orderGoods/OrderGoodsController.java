package edu.nf.generalBook.controller.orderGoods;

import edu.nf.generalBook.entity.OrderGoods;
import edu.nf.generalBook.service.es.EsService;
import edu.nf.generalBook.service.orderGoods.OrderGoodsService;
import edu.nf.generalBook.vo.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/25 09:50
 **/
@RestController
@Slf4j
public class OrderGoodsController {
    //订单功能的service
    private OrderGoodsService service;
    //搜索引擎
    private EsService esService;
    //注入
    @Autowired
    public void setEsService(EsService esService) {
        this.esService = esService;
    }

    @Autowired
    public void setService(OrderGoodsService service) {
        this.service = service;
    }

    //查询全部的订单信息
    @GetMapping("/listOrderGoods")
    public PageVO<List<OrderGoods>> listOrderGoods(Integer page, Integer limit){
        PageVO<List<OrderGoods>> vo = service.listOrderGoods(page, limit);
        return vo;
    }
    //添加一条订单
    @PostMapping("/addOrderGoods")
    public void addOrderGoods(String orderId, Integer bid, Integer number, BigDecimal unitPrice, BigDecimal totalPrice, BigDecimal money,
                             Integer uid){
        OrderGoods orderGoods = new OrderGoods();
        orderGoods.setOrderId(orderId);
        orderGoods.setBId(bid);
        orderGoods.setNumber(number);
        orderGoods.setUnitPrice(unitPrice);
        orderGoods.setTotalPrice(totalPrice);
        orderGoods.setMoney(money);
        orderGoods.setUId(uid);
        orderGoods.setCreateDate(LocalDateTime.now());
        orderGoods.setState("1");
        service.addOrderGoods(orderGoods);
    }
    //根据ID删除订单信息
    @PostMapping("/delOrderGoods")
    public void delOrderGoods(Integer oid){
        service.delOrderGoods(oid);
    }

    @GetMapping("/orderGoodsListByUid")
    public PageVO<List<OrderGoods>> orderGoodsListByUid(Integer uid){
        PageVO<List<OrderGoods>> vo = service.orderGoodsListByUid(uid);
        return vo;
    }
}
