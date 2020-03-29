package cn.zijun.product.exception;


import cn.zijun.product.enums.ResultEnum;

/**
 * @Title ProductException
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/3
 */
public class ProductException extends RuntimeException {
    private Integer code;

    public ProductException(Integer code,String message){
        super(message);
        this.code=code;
    }

    public ProductException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }
}
