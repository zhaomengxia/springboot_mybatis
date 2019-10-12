package com.hand.customer.controller;

import com.hand.customer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

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

//    @RequestMapping(value = "/login")
//    public Object testLogin(@RequestParam(value = "username") String username,
//                         @RequestParam(value = "password") String password){
//        return helloService.testService(username,password);
//    }
//
//    @RequestMapping(value = "/swagger")
//    public String testSwagger(){
//        String url="http://HAOLUNTAN/api/swagger-ui.html";
//
//        return "redirect:"+url;
//    }
}
