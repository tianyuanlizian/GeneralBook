package edu.nf.generalBook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 类型表实体类
 * @Author：tianyuan
 * @Date：2023/12/11 8:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Types {
    //类型编号
    private Integer tId;
    //类型名称
    private String name;
}
