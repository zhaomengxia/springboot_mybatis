package com.ribbon.ribbon.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign可以和Eureka和ribbon组合使用以支持负载均衡
 * @Author zhaomengxia
 * @create 2019/11/11 15:43
 */
@FeignClient(name = "service-customer")
public interface HelloRemote {

    @RequestMapping(value = "/hello")
    public String hello(@RequestParam(value = "name") String name);
}
