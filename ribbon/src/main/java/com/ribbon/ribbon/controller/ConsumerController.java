package com.ribbon.ribbon.controller;

import com.ribbon.ribbon.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author zhaomengxia
 * @create 2019/11/11 15:00
 */
@RestController
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String hello(String name) {
        //进行远程调用
        return restTemplate.getForObject("http://service-customer/hello?name="+name, String.class);
    }

    @Autowired
    HelloRemote helloRemote;

    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
        System.out.println("接受到请求参数:"+name+",进行转发到其他服务!");
        return helloRemote.hello(name);
    }


}
