package edu.nf.generalBook.vo;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author wangl
 * @date 2023/6/8
 * 统一视图想想对象
 */
@Data
public class ResultVO<T> {
    /**
     * 业务状态码
     */
    private Integer code = HttpStatus.OK.value();
    /**
     * 响应的消息
     */
    private String message;
    /**
     * 响应的数据
     */
    private T data;
}