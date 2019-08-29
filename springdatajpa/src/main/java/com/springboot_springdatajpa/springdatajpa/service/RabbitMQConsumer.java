package com.springboot_springdatajpa.springdatajpa.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @Author zhaomengxia
 * @create 2019/8/29 14:36
 */

@Service
public class RabbitMQConsumer {

    @RabbitListener(queues = "one")
    public void recevier(String message){
        System.out.println("one收到的message是："+message);
    }
    @RabbitListener(queues = "two")
    public void recevier2(String message){
        System.out.println("two收到的message是："+message);
    }
}
