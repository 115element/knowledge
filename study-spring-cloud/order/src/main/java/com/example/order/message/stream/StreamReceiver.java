package com.example.order.message.stream;

import com.example.order.dto.OrderDto;
import org.slf4j.Logger;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(StreamClient.class)
public class StreamReceiver {

    private static Logger log;

    //@StreamListener("myMessageTest")
    //public void process(Object message){
    //    log.info("StreamReceiver:{}",message);
    //}

    /**
     * 接收OrderDto对象 消息
     * @param message
     */
    @StreamListener("myMessageDemo")
    public void process(OrderDto message){
        log.info("StreamReceiver:{}",message);
    }

//////////////////////////////////////////////////////////////////////////////////

    //演示通知我得到了消息

    @StreamListener("myMessage")
    @SendTo("myMessageLol")
    public String process1(OrderDto message){
        log.info("StreamReceiver:{}",message);
        return "received.";
    }


    @StreamListener("myMessageLol")
    public void process2(OrderDto message){
        log.info("StreamReceiver2:{}",message);
    }

}
