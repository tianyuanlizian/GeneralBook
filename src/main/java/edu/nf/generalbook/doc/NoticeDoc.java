package edu.nf.generalbook.doc;

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
 * 通知的Doc，搜索引擎使用
 * @Author: tianyuan
 * @Date: 2023/12/15 11:33
 **/
@Document(indexName = "NoticeDoc", createIndex = false)
@Mapping
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDoc {
    //编号
    @Id
    private Integer nId;
    //标题
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title;
    //简介
    @Field(type = FieldType.Text)
    private String introduce;
    //详细内容
    @Field(type = FieldType.Text)
    private String details;
    //发布时间
    @Field(type = FieldType.Keyword)
    private LocalDate releaseDate;
}
