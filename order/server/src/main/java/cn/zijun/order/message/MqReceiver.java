package cn.zijun.order.message;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.impl.AMQImpl;
import com.rabbitmq.http.client.domain.ExchangeType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Title MqReceiver
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/4
 */
@Slf4j
@Component
public class MqReceiver {
    /**1.@RabbitListener(queues = "myQueue")
     * 2.@RabbitListener(queuesToDeclare = @Queue("myQueue"))
     * 3.自动创建，Exchange和Queue绑定*/
    /**
     * exchange通道
     * key为规则，关键字
     * value 为消息队列名
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(exchange = @Exchange("myOrder"),
            key = "computer",
            value = @Queue("computerOrder")))
    public void pocessComputer(String message){
        log.info("computer MqReceiver:{}",message);
    }

    @RabbitListener(bindings = @QueueBinding(exchange = @Exchange(value = "myOrder",type = ExchangeTypes.DIRECT),//通道
            key = "fruit",
            value = @Queue(value = "fruitOrder",autoDelete = "false")))
    public void processFruit(Message message, Channel channel) throws IOException {
        channel.basicQos(1,false);
        channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
        //log.info("computer MqReceiver:{}",message.getBody().toString());

    }
}
