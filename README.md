# ordermenue-SpringCloud

## 介绍
基于SpringCloud实现原订餐项目的分布式架构，原订餐服务主体由三个部分构成：订单服务，商品服务，支付服务。支付服务更多的是与第三方平台交互，暂不提供。项目由订单服务与商品服务构成。

## 分布式构成
注册中心：Eureka（若基于SpringCloud Alibaba 可替换成Nacos）  
熔断处理：Hystrix（可替换为Sentinel）  
REST客户端：Feign(同时利用其内部集成的Ribbon完成负载均衡)  
消息队列：RabbitMq（完成各模块解耦工作，消息队列其他用处可参考seckill—demo仓库）  
网关：zuul（该方案中可使用nginx完成反向代理，替换方案SpringGateway）  
注册中心：SpringConfig（使用消息队列（消息总线），以及基于GitHub的WebHooks实现配置动态更新）  


## 安装教程（基于application.yml即可）

#### 环境要求：
Java（JDK8+）  
Maven  
RabbitMq服务端程序


1.  配置Eureka（注册中心），可进行高可用配置
2.  配置config(配置中心)文件（需要拥有git平台账户，推荐使用Github，GitLab），并将各微服务，网关等通用配置文件写入平台中
3.  配置各位服务中的注册中心信息，配置中心信息等；

## 使用说明

基于分布式的架构通常开发成本运营成本较高，若业务量等各方面未达到需求，不推荐使用分布式架构



***本人仅仅初步认识SpringCloud架构，并开发本项目,有诸多不足之处，欢迎各位fork***
