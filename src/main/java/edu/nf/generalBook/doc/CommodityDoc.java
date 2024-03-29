package edu.nf.generalBook.doc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Mapping;

import java.time.LocalDate;

/**
 * 商品信息Doc，搜索引擎使用
 * @Author：tianyuan
 * @Date：2023/12/11 15:25
 */
@Document(indexName = "commodity", createIndex = false)
@Mapping
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommodityDoc {
    //编号
    @Id
    private Integer bId;
    //名称
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String bName;
    //作者
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String author;
    //出版社
    @Field(type = FieldType.Keyword)
    private String press;
    //书籍简介
    @Field(type = FieldType.Text)
    private String notes;
    //类型
    @Field(type = FieldType.Keyword)
    private String typeName;
    //发行年份
    @Field(type = FieldType.Keyword)
    private String issuingDate;
    //生产日期
    @Field(type = FieldType.Keyword)
    private LocalDate produceDate;
    //图片
    @Field(type = FieldType.Keyword)
    private String picture;
    //库存
    @Field(type = FieldType.Keyword)
    private Integer inventory;
    //状态
    @Field(type = FieldType.Keyword)
    private String state;
}
