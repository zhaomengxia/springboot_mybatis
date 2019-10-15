package com.commons.commons.basket;

/**
 * @Author zhaomengxia
 * @create 2019/10/14 16:27
 */
public class BasketTest {

    public static void main(String[] args) {

        Basket backet=new Basket();

        Thread producer=new Thread(new BasketProducerRunnable(backet));

        Thread consumer=new Thread(new BasketConsumerRunnable(backet));
        producer.start();

        consumer.start();

    }
}
