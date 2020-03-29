package cn.zijun.product.common;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Title ProductInfoOutput
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/4
 */
@Data
public class ProductInfoOutput {
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    /**0正常,1下架*/
    private Integer productStatus;

    private Integer categoryType;
}
