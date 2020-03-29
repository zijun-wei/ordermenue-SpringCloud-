package cn.zijun.product.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * @Title StreamClient
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/5
 */
@Component
public interface StreamClient {
    String INPUT="myMessage";
    String OUTPUT="myMessage2";

    @Input(INPUT)
    SubscribableChannel input();

    @Output(OUTPUT)
    MessageChannel output();
}
