package cn.zijun.order;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @Title MsgSenderTest
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/5
 */
public class MsgSenderTest extends OrderApplicationTest {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send(){
        amqpTemplate.convertAndSend("myQueue","now:"+new Date());
    }

    @Test
    public void sendOrder(){
        amqpTemplate.convertAndSend("myOrder","fruit","now:"+new Date());
    }
}
