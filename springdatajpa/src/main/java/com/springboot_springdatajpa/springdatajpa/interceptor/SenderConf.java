package com.springboot_springdatajpa.springdatajpa.interceptor;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Author zhaomengxia
 * @create 2019/8/29 14:32
 */
@Configuration
public class SenderConf {

//    Fanout模式
//    @Bean
//    public Queue queue(){
//        return new Queue("one");
//    }
//
//    @Bean
//    public Queue queue2(){
//        return new Queue("two");
//    }
//    @Bean
//    FanoutExchange exchange(){
//      return new FanoutExchange("fanout");
//    }
    //Fanout模式
//    @Bean
//    Binding bindingExchangeMessage(Queue queue,FanoutExchange fanoutExchange){
//        return BindingBuilder.bind(queue).to(fanoutExchange);
//    }
//    @Bean
//    Binding bindingExchangeMessage2(Queue queue2,FanoutExchange exchange){
//        return BindingBuilder.bind(queue2).to(exchange);
//    }

//topic模式
    @Bean(name = "one")
    public Queue queue(){
        return new Queue("one");
    }
    @Bean(name = "two")
    public Queue queue2(){
        return new Queue("two");
    }
    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange("exchange");
    }
    @Bean
    Binding bindingExchangeMessage(@Qualifier("one")Queue queue, TopicExchange exchange){

        return BindingBuilder.bind(queue).to(exchange).with("topic.#");
    }
    @Bean
    Binding bindingExchangeMessage2(@Qualifier("two")Queue queue,TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("topic.match");
    }

}
