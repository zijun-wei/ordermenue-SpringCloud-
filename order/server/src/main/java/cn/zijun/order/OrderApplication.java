package cn.zijun.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

/**
 * @Title OrderApplication
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/4
 */
/**@SpringCloudApplication中包含
 *  @SpringBootApplication
 *  @EnableDiscoveryClient
 *  @EnableCircuitBreaker
 *  默认只会扫描cn.zijun.order下的包，所以需要加@ComponentScan
 *  */
@SpringBootApplication
@EnableFeignClients(basePackages = "cn.zijun.product.client")
@EnableJpaAuditing
@EnableDiscoveryClient
@EnableCircuitBreaker
@ComponentScan(basePackages = "cn.zijun")
@EnableHystrixDashboard
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
