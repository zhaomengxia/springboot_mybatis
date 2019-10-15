package com.commons.commons.basket;

/**
 * @Author zhaomengxia
 * @create 2019/10/14 16:09
 */
public class BasketProducerRunnable implements Runnable {


    private Basket basket;

    public BasketProducerRunnable(Basket backet) {
        super();
        this.basket = backet;
    }

    @Override
    public void run() {
        while (true) {
            //定义一个同步代码块
            synchronized (basket) {
                try {
                    if (!basket.isEmpty()) {
                        //线程等待状态
                        basket.wait();
                    }
                    System.out.println("生成！");
                    basket.setEmpty(false);
                    //通知在这个共享对象上等待的线程
                    basket.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
