package cn.zijun.product.enums;

import lombok.Getter;

/**
 * @Title ProductStatusEnum
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/2
 */
@Getter
public enum ProductStatusEnum implements CodeEnum{
    UP(0,"在架"),
    DOWN(1,"下架"),
    ;

    private int code;
    private String message;

    ProductStatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
