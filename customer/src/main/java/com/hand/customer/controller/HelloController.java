package com.hand.customer.controller;

import com.hand.customer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhaomengxia
 * @create 2019/8/12 9:56
 */
@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hello")
    public String hello(@RequestParam String name){
        return helloService.helloService(name);
    }
}
