package com.hand.customer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

/**
 * @Author zhaomengxia
 * @create 2019/8/12 9:53
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "helloError")
    public String helloService(String name){
        return restTemplate.getForObject("http://SERVICE-PRODUCER/hello?name=" + name, String.class);
    }

    public String helloError(String name){
        return "hello,"+name+",sorry,error";
    }

//     @HystrixCommand(fallbackMethod = "loginError")
//    public Object testService(String username, String password){
//
//
//
//
//        return restTemplate.postForObject("http://HAOLUNTAN/api/login",username, password);
//    }
//
//    public URI loginError(String username, String password){
//
//        return null;
//    }

//
//    public HttpServletResponse testSwagger(){
//       return restTemplate.getForObject("http://HAOLUNTAN/api//swagger-ui.html#/",HttpServletResponse.class);
//    }


}
