package com.commons.commons.taskthread;

/**
 * @Author zhaomengxia
 * @create 2019/9/25 14:58
 */
public class Windows2 {
    public static void main(String[] args){
        //第一个线程
        TaskThread taskThread=new TaskThread();
        //第二个线程
        TaskThread1 taskThread1=new TaskThread1();

        //注意下面调用的是线程的start方法而不是run方法，调用run方法其实就是依次调用其中的方法，实际结果并没有实现同时执行多个方法

//        taskThread.start();
//        taskThread1.start();

        taskThread.run();
        taskThread1.run();
    }
}
