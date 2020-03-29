package cn.zijun.order.enums;

import lombok.Getter;

/**
 * @Title PayStatusEnum
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/3
 */
@Getter
public enum PayStatusEnum implements BaseEnum{
    /**
     * 支付状态，默认为等待支付
     * */
    WAIT(0,"新订单"),
    SUCCESS(1,"完结"),
    ;
    private Integer code;

    private String message;

    PayStatusEnum(Integer code,String message) {
        this.code = code;
        this.message=message;
    }
}
