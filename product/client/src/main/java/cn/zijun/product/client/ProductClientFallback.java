package cn.zijun.product.client;

import cn.zijun.product.common.DecreaseStockInput;
import cn.zijun.product.common.ProductInfoOutput;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Title ProductClientFallback
 * @Description
 * @Author Zijun Wei
 * @Date 2020/3/7
 */
@Component
public class ProductClientFallback implements ProductClient{
    @Override
    public List<ProductInfoOutput> listForOrder(List<String> productIdList) {
        return null;
    }

    @Override
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {

    }
}
