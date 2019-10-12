package com.commons.commons.taskthread;

/**
 * @Author zhaomengxia
 * @create 2019/9/25 14:55
 */
public class TaskThread1 extends Thread {

    @Override
    public void run() {
        for (int j = 0; j < 100; j++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("j=" + j);
        }
    }
}
