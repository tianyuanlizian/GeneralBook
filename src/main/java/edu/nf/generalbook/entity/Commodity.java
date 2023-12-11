package edu.nf.generalbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author：tianyuan
 * @Date：2023/12/11 15:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commodity {
    //编号
    private Integer bId;
    //名称
    private String bName;
    //作者
    private String author;
    //出版社
    private String press;
    //书籍简介
    private String notes;
    //类型编号
    private Integer tId;
    //发行年份
    private String issuingDate;
    //生产日期
    private Date produceDate;
    //图片
    private String picture;
    //库存
    private Integer inventory;
    //状态
    private String state;
    //类型对象
    private Types types;
}
