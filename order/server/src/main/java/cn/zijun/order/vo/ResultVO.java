package cn.zijun.order.vo;

import lombok.Data;

/**
 * @Title ResultVO
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/3
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
