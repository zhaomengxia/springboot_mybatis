package com.consumer2.consumer2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhaomengxia
 * @create 2019/11/11 16:25
 */
@RestController
public class ConsumerController {

    @RequestMapping("/hello")
    public String test(String name){
        return "Hello World 模拟负载均衡的另一个消费者服务 "+name;
    }
}
