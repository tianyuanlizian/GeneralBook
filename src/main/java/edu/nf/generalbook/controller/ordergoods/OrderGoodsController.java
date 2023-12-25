package edu.nf.generalbook.controller.ordergoods;

import edu.nf.generalbook.entity.Commodity;
import edu.nf.generalbook.entity.OrderGoods;
import edu.nf.generalbook.service.commodity.CommodityService;
import edu.nf.generalbook.service.es.EsService;
import edu.nf.generalbook.service.ordergoods.OrderGoodsService;
import edu.nf.generalbook.vo.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/25 09:50
 **/
@RestController
@Slf4j
public class OrderGoodsController {
    private OrderGoodsService service;

    private EsService esService;
    @Autowired
    public void setEsService(EsService esService) {
        this.esService = esService;
    }

    @Autowired
    public void setService(OrderGoodsService service) {
        this.service = service;
    }

    @GetMapping("/listOrderGoods")
    public PageVO<List<OrderGoods>> listOrderGoods(Integer page, Integer limit){
        PageVO<List<OrderGoods>> vo = service.listOrderGoods(page, limit);
        return vo;
    }

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

    @PostMapping("/delOrderGoods")
    public void delOrderGoods(Integer oid){
        service.delOrderGoods(oid);
    }
}
