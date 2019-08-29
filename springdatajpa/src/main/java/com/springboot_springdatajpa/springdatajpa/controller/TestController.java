package com.springboot_springdatajpa.springdatajpa.controller;

import com.springboot_springdatajpa.springdatajpa.service.RabbitMQProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhaomengxia
 * @create 2019/8/29 14:39
 */
@RestController
public class TestController {
    @Autowired
    private RabbitMQProvider rabbitMQProvider;

//    @RequestMapping("/test")
//    public boolean sendOne(){
//        return rabbitMQProvider.send();
//    }
//
//    @RequestMapping("/test2")
//    public boolean sendFanout(){
//        return rabbitMQProvider.send2();
//    }

    @RequestMapping("/testTopicOne")
    public  boolean sendTOpicOne(){
        return rabbitMQProvider.send1();
    }

    @RequestMapping("/testTopicTwo")
    public boolean sendTopicTwo(){
        return rabbitMQProvider.send2();
    }
}
