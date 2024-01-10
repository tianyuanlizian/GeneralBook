package edu.nf.generalBook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单表实体类
 * @Author: tianyuan
 * @Date: 2023/12/19 16:22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderGoods {
    //编号
    private Integer oId;
    //订单号
    private String orderId;
    //商品ID
    private Integer bId;
    //数量
    private Integer number;
    //单价
    private BigDecimal unitPrice;
    //总价
    private BigDecimal totalPrice;
    //实付金额
    private BigDecimal money;
    //用户id
    private Integer uId;
    //购买时间
    private LocalDateTime createDate;
    //状态
    private String state;

    //商品对象
    private Commodity commodity;
    //用户对象
    private User user;
}
