package cn.zijun.order.enums;

import lombok.Getter;

/**
 * @Title ResultEnum
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/3
 */
@Getter
public enum ResultEnum {

    PARAM_ERROR(1,"参数错误"),
    CART_EMPTY(2,"购物车为空"),
    ORDER_NOT_EXSIT(3,"订单不存在"),
    ORDER_STATUS_ERROR(4,"订单状态错误"),
    ORDER_DETAIL_NOT_EXSIT(5,"订单详情不存在"),
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
