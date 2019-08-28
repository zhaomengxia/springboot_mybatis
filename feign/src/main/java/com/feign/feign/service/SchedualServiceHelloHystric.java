package com.feign.feign.service;

import org.springframework.stereotype.Component;

/**
 * @Author zhaomengxia
 * @create 2019/8/27 20:52
 */
@Component
public class SchedualServiceHelloHystric implements SchedualServiceHello{
    @Override
    public String sayHello(String name) {
        return "sorry,"+name;
    }
}
