package edu.nf.generalBook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 收藏表实体类
 * @Author: tianyuan
 * @Date: 2023/12/27 09:49
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collect {
    //ID
    private Integer coId;
    //商品编号
    private Integer bId;
    //添加收藏时间
    private LocalDateTime createDate;
    //用户ID
    private Integer uId;

    //商品对象
    private Commodity commodity;
    //用户对象
    private User user;
}
