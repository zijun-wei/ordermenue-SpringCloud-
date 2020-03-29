package cn.zijun.order.message;

import cn.zijun.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @Title StreamReceiver
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/5
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

    @StreamListener("myMessage")
    public void process(Message<String> message){
      log.info("StreamReceiver: {}",message.getPayload());
    }

//    @StreamListener("myMessage")
//    public void processOrderDTO(OrderDTO message){
//        log.info("StreamReceiver: {}",message);
//    }
}
