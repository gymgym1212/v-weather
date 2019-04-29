package com.example.bigdata.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
@Component
public class MyConsumer {


    @JmsListener(destination = "test.queue")
    public void receiveQueue(String text) {
        System.out.println("MyConsumer收到的报文为:" + text);
    }
}
