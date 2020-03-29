package cn.zijun.order.message;

import cn.zijun.order.utils.JsonUtil;
import cn.zijun.product.common.ProductInfoOutput;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Title ProductInfoReceiver
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/5
 */
@Component
@Slf4j
public class ProductInfoReceiver {

    private static final String PRODUCT_STOCK_TEMPLATE="product_stock_%s";

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message){
        /**List<ProductInfoOutput> productInfoOutputList=JsonUtil.fromJson(message,new TypeReference<List<ProductInfoOutput>>(){});*/
        List<ProductInfoOutput> productInfoOutputList=JsonUtil.fromJson(message,new TypeToken<List<ProductInfoOutput>>(){});

        log.info("从消息队列【productInfo】接受到消息：{}",productInfoOutputList);

        for (ProductInfoOutput productInfoOutput:productInfoOutputList){
            redisTemplate.opsForValue().set(
                String.format(PRODUCT_STOCK_TEMPLATE,productInfoOutput.getProductId()),
                String.valueOf(productInfoOutput.getProductStock()));
        }
    }

}
