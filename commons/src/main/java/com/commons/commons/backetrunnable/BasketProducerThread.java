package com.commons.commons.backetrunnable;

/**
 * @Author zhaomengxia
 * @create 2019/10/14 16:09
 */
public class BasketProducerThread extends Thread {


    private Basket basket;

    public BasketProducerThread(Basket basket) {
        super();
        this.basket = basket;
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
