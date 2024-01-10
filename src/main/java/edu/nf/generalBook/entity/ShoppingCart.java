package edu.nf.generalBook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: tianyuan
 * @Date: 2024/1/10 16:10
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {
    //购物车ID
    private Integer scId;
    //用户Id
    private Integer uId;
    //商品Id
    private Integer bId;
    //数量
    private Integer num;

    //用户对象
    private User user;
    //商品对象
    private Commodity commodity;
}
