package com.springsecurity.springsecurity.security.model;

/**
 * @Author zhaomengxia
 * @create 2019/8/8 17:14
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        son son = new son();
    }
}

class parent {
    private static int a = 1;
    private static int b;
    private int c = initc();

    {
        System.out.println("父类代码块");
    }

    public parent(int c) {
        this.c = c;
        System.out.println("父类有参构造方法");
    }

    public parent() {
        System.out.println("父类无参构造方法");
    }

    int initc() {
        System.out.println("3.父类成员变量赋值：---> c的值" + c);
        this.c = 12;
        System.out.println("3.父类成员变量赋值：---> c的值" + c);
        return c;
    }

    static {
        b = 1;
        System.out.println("1.父类静态代码块：赋值b成功");
        System.out.println("1.父类静态代码块：a的值" + a);
    }


}

class son extends parent {
    private static int sa = 1;
    private static int sb;
    private int sc = initc2();

    public son() {
        System.out.println("子类空参构造方法");
    }

    static {
        sb = 1;
        System.out.println("2.子类静态代码块：赋值sb成功");
        System.out.println("2.子类静态代码块：sa的值" + sa);
    }

    {
        System.out.println("子类代码块");
    }

    int initc2() {
        System.out.println("5.子类成员变量赋值--->：sc的值" + sc);
        this.sc = 12;
        return sc;
    }

    public son(int c, int sc) {
        super(c);
        this.sc = sc;
        System.out.println("子类构造方法");
    }

    public son(int sc) {
        this.sc = sc;
        System.out.println("子类构造方法");
    }
}