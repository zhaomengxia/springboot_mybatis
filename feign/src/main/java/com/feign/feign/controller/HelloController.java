package com.feign.feign.controller;

import com.feign.feign.service.SchedualServiceHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhaomengxia
 * @create 2019/8/28 9:51
 */
@RestController
public class HelloController {
    @Autowired
    private SchedualServiceHello schedualServiceHello;

    @RequestMapping(value = "/sayHello")
    public String sayHello(@RequestParam String name){
        return schedualServiceHello.sayHello(name);
    }
}
