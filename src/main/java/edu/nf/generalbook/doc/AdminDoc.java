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
 * @Date: 2023/12/19 09:42
 **/
@Document(indexName = "admin", createIndex = false)
@Mapping
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDoc {
    //编号
    @Id
    private Integer adId;
    //名称
    @Field(type = FieldType.Keyword)
    private String adName;
    //账号
    @Field(type = FieldType.Keyword)
    private String account;
    //密码
    @Field(type = FieldType.Keyword)
    private String password;
    //状态
    @Field(type = FieldType.Keyword)
    private String state;
}
