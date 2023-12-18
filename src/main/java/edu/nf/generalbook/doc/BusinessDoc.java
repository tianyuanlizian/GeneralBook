package edu.nf.generalbook.doc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Mapping;

/**
 * @Author: tianyuan
 * @Date: 2023/12/18 09:26
 **/
@Document(indexName = "business", createIndex = false)
@Mapping
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessDoc {
    //编号
    @Id
    private Integer buId;
    //名称
    @Field(type = FieldType.Keyword)
    private String buName;
    //地址
    @Field(type = FieldType.Keyword)
    private String address;
    //联系电话
    @Field(type = FieldType.Keyword)
    private String phone;
    //邮箱
    @Field(type = FieldType.Keyword)
    private String email;
    //图片
    @Field(type = FieldType.Keyword)
    private String picture;
    //简介
    @Field(type = FieldType.Text)
    private String introduce;
}
