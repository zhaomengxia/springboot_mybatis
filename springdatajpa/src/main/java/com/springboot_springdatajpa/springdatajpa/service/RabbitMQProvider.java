package com.springboot_springdatajpa.springdatajpa.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zhaomengxia
 * @create 2019/8/29 14:34
 */
@Service
public class RabbitMQProvider {

    @Autowired
    private AmqpTemplate amqpTemplate;
//direct模式
//    public boolean send(){
//
//        amqpTemplate.convertAndSend("one","direct test......");
//        return true;
//    }
    //Fanout模式

//    public boolean send2(){
//        amqpTemplate.convertAndSend("fanout","eee","fanout test......");
//
//        return true;
//    }

    public boolean send1(){
        amqpTemplate.convertAndSend("exchange","topic.all","topic-1 test.topic......");
        return true;
    }

    public boolean send2(){
        amqpTemplate.convertAndSend("exchange","topic.match","topic-2 topic2......");

        return true;
    }

}
