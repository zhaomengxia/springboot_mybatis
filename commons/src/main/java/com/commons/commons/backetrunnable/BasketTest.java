package com.commons.commons.backetrunnable;

/**
 * @Author zhaomengxia
 * @create 2019/10/14 16:27
 */
public class BasketTest {

    public static void main(String[] args) {

        Basket basket =new Basket();

        BasketProducerThread basketProducerThread =new BasketProducerThread(basket);

        BasketConsumerRunnable basketConsumerThread=new BasketConsumerRunnable(basket);

        basketProducerThread.start();

        basketConsumerThread.start();

    }
}
