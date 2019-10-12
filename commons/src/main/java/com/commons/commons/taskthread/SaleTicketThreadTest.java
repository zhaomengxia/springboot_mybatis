package com.commons.commons.taskthread;

/**
 * @Author zhaomengxia
 * @create 2019/10/12 17:02
 */
public class SaleTicketThreadTest {

    public static void main(String[] args) {

        SaleTicketThread saleTicketThread=new SaleTicketThread("窗口1");

        SaleTicketThread saleTicketThread1=new SaleTicketThread("窗口2");

        SaleTicketThread saleTicketThread2=new SaleTicketThread("窗口3");

        SaleTicketThread saleTicketThread3=new SaleTicketThread("窗口4");
        saleTicketThread.start();
        saleTicketThread1.start();
        saleTicketThread2.start();
        saleTicketThread3.start();

    }
}
