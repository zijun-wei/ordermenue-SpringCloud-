package cn.zijun.product;

import cn.zijun.product.message.StreamClient;
import cn.zijun.product.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Title StreamSenderTest
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/3/5
 */

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@EnableBinding(StreamClient.class)
//public class StreamSenderTest {
//
//    @Autowired
//    private StreamClient streamClient;
//
//    @Test
//    public void process(){
//
//        String msg="now"+new Date();
//        streamClient.output().send(MessageBuilder.withPayload(msg).build());
//    }
//}
