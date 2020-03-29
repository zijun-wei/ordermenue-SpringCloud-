package cn.zijun.product.common;

import lombok.Data;

/**
 * @Title DecreaseStockInput
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/4
 */
@Data
public class DecreaseStockInput {

    private String productId;

    private Integer productQuantity;

    public DecreaseStockInput(){}

    public DecreaseStockInput(String productId,Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
