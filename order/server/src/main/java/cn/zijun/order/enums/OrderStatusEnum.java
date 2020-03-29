package cn.zijun.order.enums;

import lombok.Getter;

/**
 * @Title OrderStatusEnum
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/3
 */
@Getter
public enum OrderStatusEnum implements BaseEnum{

    /**
     * 订单状态，默认为新订单
     * */
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消"),
    ;
    private Integer code;

    private String message;

    OrderStatusEnum(Integer code,String message) {
        this.code = code;
        this.message=message;
    }
}
