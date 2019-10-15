package com.commons.commons.taskthread;

/**
 * @Author zhaomengxia
 * @create 2019/10/12 17:41
 */
public class SaleTicketRunnableTest {
    public static void main(String[] args) {

        SaleTicketRunnable saleTicketRunnable=new SaleTicketRunnable();

        Thread thread=new Thread(saleTicketRunnable,"窗口1");

        Thread thread1=new Thread(saleTicketRunnable,"窗口2");

        Thread thread2=new Thread(saleTicketRunnable,"窗口3");

        Thread thread3=new Thread(saleTicketRunnable,"窗口4");
        //设置该线程可以拥有最大优先级
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
