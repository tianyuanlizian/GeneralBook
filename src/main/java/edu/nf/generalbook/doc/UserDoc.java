package edu.nf.generalbook.doc;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Mapping;

/**
 * @Author：tianyuan
 * @Date：2023/12/5 9:43
 */
@Document(indexName = "user", createIndex = false)
@Mapping
@Data
public class UserDoc {
        //编号
        @Id
        private Integer uId;
        //用户名称
        @Field(type = FieldType.Text, analyzer = "ik_max_word")
        private String name;
        //用户账号
        @Field(type = FieldType.Keyword)
        private String account;
        //密码
        @Field(type = FieldType.Keyword)
        private String password;
        //性别
        @Field(type = FieldType.Keyword)
        private String sex;
        //邮箱
        @Field(type = FieldType.Keyword)
        private String email;
        //头像
        @Field(type = FieldType.Keyword)
        private String photo;
        //手机号码
        @Field(type = FieldType.Keyword)
        private String phone;
        //状态
        @Field(type = FieldType.Keyword)
        private String state;

}