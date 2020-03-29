package cn.zijun.order.exception;

import cn.zijun.order.enums.ResultEnum;

/**
 * @Title OrderException
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/3
 */
public class OrderException extends RuntimeException {
    private Integer code;

    public OrderException(Integer code,String message) {
        super(message);
        this.code = code;
    }
    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
