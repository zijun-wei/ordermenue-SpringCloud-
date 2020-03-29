package cn.zijun.product.enums;

import lombok.Getter;

/**
 * @Title ResultEnum
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/3
 */
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(1,"商品不存在"),
    PRODUCT_STOCK_ERROR(2,"库存有误"),
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code,String message){
        this.code=code;
        this.message=message;
    }
}
