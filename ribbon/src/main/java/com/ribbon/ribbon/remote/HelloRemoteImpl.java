package com.ribbon.ribbon.remote;

import org.springframework.stereotype.Service;

/**
 * @Author zhaomengxia
 * @create 2019/11/11 15:53
 */
@Service
public class HelloRemoteImpl implements HelloRemote {
    @Override
    public String hello(String name) {
        return "Hello World"+name;
    }
}
