package com.springboot_springdatajpa.springdatajpa.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * 用户接口，用于测试的接口
 * 这里使用了标准的restful接口的风格，swagger自动的API接口，shiro接口权限注解
 * @RequiresPermissions组合成的一个controller。当然也可以使用其他技术，只要能够获取到接口信息就行
 * @Author zhaomengxia
 * @create 2019/9/3 11:26
 */
@RestController
@Api(tags = "登录")
@RequestMapping("/test")
public class LoginController {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation("登录接口")
    @RequiresPermissions("user:list")
    public String login(
            @RequestParam(value = "username", required = true) String userName,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "rememberMe", required = true, defaultValue = "false") boolean rememberMe
    ) {
        logger.info("==========" + userName + password + rememberMe);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        token.setRememberMe(rememberMe);

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
//            rediect.addFlashAttribute("errorText", "您的账号或密码输入错误!");
            return "{\"Msg\":\"您的账号或密码输入错误\",\"state\":\"failed\"}";
        }
        return "{\"Msg\":\"登陆成功\",\"state\":\"success\"}";
    }

    @RequestMapping("/")
    @ResponseBody
    @RequiresPermissions("user:get")
    @ApiOperation(value = "测试")
    public String index() {
        return "no permission";
    }
}

