package com.springsecurityjwt.springsecurityjwt.controller;

import com.springsecurityjwt.springsecurityjwt.service.impl.UserDetailsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author zhaomengxia
 * @create 2019/9/23 10:03
 */
@RestController
@RequestMapping(value = "/user/")
@Api(description = "查询用户信息")
public class UserController{
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping(value = "findByUserName")
    @ApiOperation(value = "通过用户名查找用户信息")
    public ResponseEntity<?> findByUserName(String userName){
        return ResponseEntity.ok(userDetailsService.findAll(userName));
    }


}
