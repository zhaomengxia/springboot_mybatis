package com.springboot_springdatajpa.springdatajpa.repository;

/**
 * @Author zhaomengxia
 * @create 2019/8/7 9:32
 */
public abstract class TestAbstact implements TestDao {
    @Override
    public String getAll() {
        return "sssaas";
    }
}
