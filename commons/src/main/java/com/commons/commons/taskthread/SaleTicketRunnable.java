package com.commons.commons.taskthread;

/**
 * @Author zhaomengxia
 * @create 2019/10/12 17:39
 */
public class SaleTicketRunnable implements Runnable {
    private String name;

    public SaleTicketRunnable() {
    }

    public SaleTicketRunnable(String name) {
        this.name = name;
    }
    //共享数据
     int number = 200;

    @Override
    public void run() {
        while (true) {
                if (number > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖出" + (number--) + "号");
                } else {
                    break;
                }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "卖票结束！");

    }
}
