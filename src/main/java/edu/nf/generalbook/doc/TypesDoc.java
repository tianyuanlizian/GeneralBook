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
 * 类型的Doc，搜索引擎使用
 * @Author：tianyuan
 * @Date：2023/12/11 8:58
 */
@Document(indexName = "types", createIndex = false)
@Mapping
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypesDoc {
    //类型编号
    @Id
    private Integer tId;
    //类型名称
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String name;
}
