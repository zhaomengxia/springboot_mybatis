package com.commons.commons.testthread;

/**
 * @Author zhaomengxia
 * @create 2019/10/15 9:59
 */
public class ThreadDemoTest {


    public static void main(String[] args) {

        ThreadDemo threadDemo=new ThreadDemo("电影1");

        threadDemo.setDaemon(true);
        threadDemo.start();

        System.out.println("主线程main结束!");
    }
}
