package com.springsecurity.springsecurity.security.model;

/**
 * @Author zhaomengxia
 * @create 2019/8/9 9:49
 */
public class Test {

    public static void main(String[] args){


        String s1=new StringBuilder("go").append("od").toString();

        System.out.println(s1.intern()==s1);

        String s2=new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern()==s2);




    }
}
