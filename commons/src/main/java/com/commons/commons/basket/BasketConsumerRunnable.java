package com.commons.commons.basket;

/**
 * @Author zhaomengxia
 * @create 2019/10/14 16:22
 */
public class BasketConsumerRunnable implements Runnable {


    private Basket basket;

    public BasketConsumerRunnable(Basket basket) {
        super();
        this.basket = basket;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (basket) {
                try {
                    if (basket.isEmpty()) {

                        basket.wait();
                    }
                    System.out.println("消费！");
                    basket.setEmpty(true);
                    basket.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
