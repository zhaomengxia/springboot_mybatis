package com.ribbon.ribbon.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 制定负载均衡策略
 * @Author zhaomengxia
 * @create 2019/11/11 15:40
 */
@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule ribbonRule(){
        //随机负载
        return new RandomRule();
    }

}
