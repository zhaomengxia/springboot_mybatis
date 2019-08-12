package com.hand.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author zhaomengxia
 * @create 2019/8/12 9:53
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String helloService(String name){
        return restTemplate.getForObject("http://SERVICE-PRODUCER/hello?name=" + name, String.class);
    }

}
