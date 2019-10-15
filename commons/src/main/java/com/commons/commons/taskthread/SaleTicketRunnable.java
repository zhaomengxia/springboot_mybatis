package com.commons.commons.taskthread;

/**
 * @Author zhaomengxia
 * @create 2019/10/12 17:39
 */
public class SaleTicketRunnable implements Runnable {
    private String name;

    public SaleTicketRunnable() {
    }

    Object object=new Object();
    public SaleTicketRunnable(String name) {
        this.name = name;
    }
    //共享数据
     int number = 500;

    @Override
    public void run() {
        while (true) {
//            synchronized (object) {
//                if (number > 0) {
//                    System.out.println(Thread.currentThread().getName() + "卖出" + (number--) + "号");
//                } else {
//                    break;
//                }
//            }
            if (tickets()){
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


    public  boolean tickets(){

        synchronized (object) {
            boolean f = false;
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出" + (number--) + "号");
            } else {
                f = true;
            }
            return f;
        }

    }
}
