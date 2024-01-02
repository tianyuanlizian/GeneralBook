package edu.nf.generalbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 地址实体类
 * @Author: tianyuan
 * @Date: 2023/12/27 08:35
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressInfo {
    //ID
    private Integer aId;
    //收件人
    private String aName;
    //详细地址
    private String address;
    //联系电话
    private String phone;
    //用户id
    private Integer uId;
    //用户对象
    private User user;
}
