package edu.nf.generalbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @Author: tianyuan
 * @Date: 2023/12/15 11:14
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {
    //编号
    private Integer nId;
    //标题
    private String title;
    //简介
    private String introduce;
    //详细内容
    private String details;
    //发布时间
    private LocalDate date;
}
