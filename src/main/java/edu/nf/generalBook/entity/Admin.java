package edu.nf.generalBook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 管理员实体类
 * @Author: tianyuan
 * @Date: 2023/12/19 09:36
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    //编号
    private Integer adId;
    //名称
    private String adName;
    //账号
    private String account;
    //密码
    private String password;
    //状态
    private String state;
}
