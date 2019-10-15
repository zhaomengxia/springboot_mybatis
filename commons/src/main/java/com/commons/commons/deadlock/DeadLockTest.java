package com.commons.commons.deadlock;

/**
 * @Author zhaomengxia
 * @create 2019/10/15 10:41
 */
public class DeadLockTest {

    public static void main(String[] args) {
        DeadLockThread deadLockThread=new DeadLockThread();
        deadLockThread.flag=1;
        DeadLockThread deadLockThread1=new DeadLockThread();
        deadLockThread.start();
        deadLockThread1.start();
    }


}
