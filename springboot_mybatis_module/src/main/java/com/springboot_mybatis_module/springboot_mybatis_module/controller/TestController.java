package com.springboot_mybatis_module.springboot_mybatis_module.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhaomengxia
 * @create 2019/8/6 17:47
 */
@Api(description = "测试")
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping(value = "/test")
    @ApiOperation(value = "hgghss")
    public String test(){
        System.out.println("uuuu");
        return "wwsss";
    }
}
