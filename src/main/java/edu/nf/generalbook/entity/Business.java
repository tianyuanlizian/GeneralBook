package edu.nf.generalbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: tianyuan
 * @Date: 2023/12/18 09:09
 **/

/**
 * 商家信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Business {
    //编号
    private Integer buId;
    //名称
    private String buName;
    //地址
    private String address;
    //联系电话
    private String phone;
    //邮箱
    private String email;
    //图片
    private String picture;
    //简介
    private String introduce;
}
