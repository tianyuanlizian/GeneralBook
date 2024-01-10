package edu.nf.generalBook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: tianyuan
 * @Date: 2024/1/4 09:58
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImgTest {
    private Integer id;
    private String imgPath;
    private String describes;
}
