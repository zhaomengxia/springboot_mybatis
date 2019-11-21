package com.commons.commons.debug;

/**
 * @Author zhaomengxia
 * @create 2019/11/14 13:59
 */
public class DropFrameDebug {


    public static void main(String[] args) {
        int i=99;
        methodOne(i);
    }

    public static  void methodOne(int i){
        System.out.println("method1:"+i);
        methodTwo(i);
    }

    public static void methodTwo(int j){
        j++;
        System.out.println("method2:"+j);
    }

}
