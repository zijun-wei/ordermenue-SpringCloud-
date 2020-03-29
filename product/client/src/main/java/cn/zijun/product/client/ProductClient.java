package cn.zijun.product.client;

import cn.zijun.product.common.DecreaseStockInput;
import cn.zijun.product.common.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Title ProductClient
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/4
 */

@FeignClient(name="product-service",fallback = ProductClientFallback.class)
public interface ProductClient {
    @PostMapping("/product/listForOrder")
    List<ProductInfoOutput> listForOrder(@RequestBody List<String>productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput>decreaseStockInputList);
}
