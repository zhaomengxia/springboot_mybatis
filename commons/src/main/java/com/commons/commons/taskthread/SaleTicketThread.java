package com.commons.commons.taskthread;

/**
 * @Author zhaomengxia
 * @create 2019/10/12 16:56
 */
public  class SaleTicketThread extends Thread {

    static int number = 500;

    private String name;

    //创建一个锁对象，这个对象是多个线程对象共享的数据
    static Object object = new Object();

    public SaleTicketThread(String name) {

        super(name);
        this.name = name;
    }


    @Override
    public void run() {
        while (true) {
//            synchronized (object){
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
        System.out.println(name + "票卖完了！");
    }

    /**
     * 此时synchronized在方法上，此时锁对象是this
     */
    public static synchronized boolean tickets() {
        boolean f = false;
//        synchronized (object) {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出" + (number--) + "号");
            } else {
                f = true;
            }
//        }
        return f;

    }
}
