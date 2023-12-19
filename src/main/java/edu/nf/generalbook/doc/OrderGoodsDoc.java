package edu.nf.generalbook.doc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Mapping;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: tianyuan
 * @Date: 2023/12/19 19:09
 **/
@Document(indexName = "orderGoods", createIndex = false)
@Mapping
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderGoodsDoc {
    //编号
    @Id
    private Integer oId;
    //订单号
    @Field(type = FieldType.Keyword)
    private String orderId;
    //商品ID
    @Field(type = FieldType.Keyword)
    private Integer bId;
    //数量
    @Field(type = FieldType.Keyword)
    private Integer number;
    //单价
    @Field(type = FieldType.Keyword)
    private BigDecimal unitPrice;
    //总价
    @Field(type = FieldType.Keyword)
    private BigDecimal totalPrice;
    //实付金额
    @Field(type = FieldType.Keyword)
    private BigDecimal money;
    //用户id
    @Field(type = FieldType.Keyword)
    private Integer uId;
    //购买时间
    @Field(type = FieldType.Keyword)
    private Date createDate;
    //状态
    @Field(type = FieldType.Keyword)
    private String state;
}
