package com.commons.commons.taskthread;

/**
 * @Author zhaomengxia
 * @create 2019/9/25 14:54
 */
public class TaskThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i= " + i);
        }
    }
}
