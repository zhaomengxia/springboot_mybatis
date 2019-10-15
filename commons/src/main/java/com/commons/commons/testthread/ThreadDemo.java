package com.commons.commons.testthread;

/**
 * @Author zhaomengxia
 * @create 2019/10/15 9:57
 */
public class ThreadDemo extends Thread{


    private String name;

    public ThreadDemo(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <=100 ; i++) {
            System.out.println(this.name+"下载了："+i+"%");
            //执行一次，让出cpu资源，线程之间比较谦让
//            Thread.yield();
        }
    }
}
