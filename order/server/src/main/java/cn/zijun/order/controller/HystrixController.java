package cn.zijun.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.ClientProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @Title HystrixController
 * @Description
 * @Author Zijun Wei
 * @Date 2020/3/7
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {
    @Autowired
    private RestTemplate restTemplate;


    /**
     * @HystrixCommand(commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
     *      (fallbackMethod = "fallback")
     *     @HystrixCommand(commandProperties = {
     *             @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
     *             @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
     *             @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "100"),
     *             @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
     *     })
     * @param number
     * @return
     */

    @HystrixCommand
    @GetMapping("/getProductInfoList")
    public String getProductInfoList(@RequestParam("number") Integer number) {
        if (number%2==0){
            return "success";
        }
        String s = restTemplate.postForObject("http://product-service/product/listForOrder",
                Arrays.asList("123456"), String.class);
        return s;
    }

    private String fallback(){
        return "太拥挤了，请稍后再试";
    }
    private String defaultFallback(){
        return "默认提示：太拥挤了，请稍后再试";
    }
}
