package edu.nf.generalbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
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
