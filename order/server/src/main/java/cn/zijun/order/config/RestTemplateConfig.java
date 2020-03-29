package cn.zijun.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Title RestTemplateFactory
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/3
 */

@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplateCase(){
        return new RestTemplate();
    }
}
