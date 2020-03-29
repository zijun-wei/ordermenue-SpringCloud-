package cn.zijun.order;

import cn.zijun.order.dto.OrderDTO;
import cn.zijun.order.message.StreamClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Title StreamSenderTest
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/5
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamSenderTest {

    @Autowired
    private StreamClient streamClient;

    @Test
    public void process(){
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setOrderId("123456");

        //String msg="now"+new Date();
        streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
    }
}
