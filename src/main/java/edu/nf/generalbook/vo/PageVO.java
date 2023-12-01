package edu.nf.generalbook.vo;

import lombok.Data;

/**
 * @author wangl
 * @date 2023/6/8
 * 分页视图对象
 */
@Data
public class PageVO<T> extends ResultVO<T> {
    /**
     * 总记录数
     * layui需要用到这个字段来计算出总页数
     */
    private Long count;
}