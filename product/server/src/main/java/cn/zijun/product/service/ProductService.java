package cn.zijun.product.service;

import cn.zijun.product.common.DecreaseStockInput;
import cn.zijun.product.common.ProductInfoOutput;
import cn.zijun.product.dto.CartDTO;
import cn.zijun.product.pojo.ProductInfo;

import java.util.List;

/**
 * @Title ProductService
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/3
 */
public interface ProductService {

    List<ProductInfo>findUpAll();

    List<ProductInfoOutput>findList(List<String> productIdList);

    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
