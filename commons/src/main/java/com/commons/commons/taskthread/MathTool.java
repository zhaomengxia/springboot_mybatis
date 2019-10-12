package com.commons.commons.taskthread;

/**
 * @Author zhaomengxia
 * @create 2019/9/25 15:45
 */
public class MathTool {


    public static int sum(int[] atr) {
        int result = 0;
        for (int a : atr) {
            result += a;
        }
        return result;
    }


    public static int sum1(int... atr1) {//int类型参数的个数是从0开始
        //本质上的处理方法跟数组一样，就把它当作数组
        int result = 0;
        for (int a : atr1) {
            result += a;
        }
        return result;
    }
    //创建一个锁对象，这个对象是多个线程对象共享的数据
//    static Object obj=new Object();

    public static void main(String[] args) {

//        int[] atr={1,2,3,4,5};
//        int result = sum(new int[]{1, 2, 3, 4, 5});//如果这里没有判断数组是否位null
        int[] atr=null;
//        int result = sum(atr);//这种情况这一步就会报空指针异常
//        System.out.println("result=" + result);

//        int result1 = sum1(1, 2, 3, 4, 5);
        int result1 = sum1();//而这里输出结果是0
        System.out.println("result1=" + result1);
    }
}
