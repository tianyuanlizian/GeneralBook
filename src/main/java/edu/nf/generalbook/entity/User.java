package edu.nf.generalbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：tianyuan
 * @Date：2023/11/30 9:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //编号
    private Integer uId;
    //用户名称
    private String name;
    //用户账号
    private String account;
    //密码
    private String password;
    //性别
    private String sex;
    //邮箱
    private String email;
    //头像
    private String photo;
    //手机号码
    private String phone;
    //状态
    private String state;
}