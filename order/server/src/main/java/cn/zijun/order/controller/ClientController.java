package cn.zijun.order.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Title ServerController
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/3
 */
@RestController
@RequestMapping
@RefreshScope
public class ClientController {

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/getProductMsg")
    public String msg(){

        //第一种，直接用restTemplate，需要@LoadBalance才能用service-id
        //String object = restTemplate.getForObject("http://product-service/msg", String.class);


        //第二种
        RestTemplate restTemplate=new RestTemplate();
        ServiceInstance serviceInstance= loadBalancerClient.choose("product-service");
//        List<ServiceInstance> serviceInstanceList=discoveryClient.getInstances("product-service");
//        ServiceInstance serviceInstance=serviceInstanceList.get(0);

        String url=String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort())+"/msg";
        String result = restTemplate.getForObject(url, String.class);
        return null;
    }
}
