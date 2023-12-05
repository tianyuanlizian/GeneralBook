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
        @Id
        //编号
        private Integer uId;
        @Field(type = FieldType.Text, analyzer = "ik_max_word")
        //用户名称
        private String name;
        @Field(type = FieldType.Keyword)
        //用户账号
        private String account;
        @Field(type = FieldType.Keyword)
        //密码
        private String password;
        @Field(type = FieldType.Keyword)
        //性别
        private String sex;
        @Field(type = FieldType.Keyword)
        //邮箱
        private String email;
        @Field(type = FieldType.Keyword)
        //头像
        private String photo;
        @Field(type = FieldType.Keyword)
        //手机号码
        private String phone;
        @Field(type = FieldType.Keyword)
        //状态
        private String state;

}
