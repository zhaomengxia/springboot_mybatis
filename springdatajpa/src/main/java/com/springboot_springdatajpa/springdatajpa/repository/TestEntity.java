package com.springboot_springdatajpa.springdatajpa.repository;

/**
 * @Author zhaomengxia
 * @create 2019/8/7 9:44
 */
public class TestEntity extends TestAbstact {

    @Override
    public boolean getOne() {
        return false;
    }

    @Override
    public double getDouble() {
        return 0;
    }

    @Override
    public int getInt() {
        return 0;
    }
}
