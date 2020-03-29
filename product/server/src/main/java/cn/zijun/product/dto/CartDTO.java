package cn.zijun.product.dto;

import lombok.Data;

/**
 * @Title CartDTO
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/3
 */

@Data
public class CartDTO {

    private String productId;

    private Integer productQuantity;

    public CartDTO(){}

    public CartDTO(String productId,Integer productQuantity){
        this.productId=productId;
        this.productQuantity=productQuantity;
    }
}
