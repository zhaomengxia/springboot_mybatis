package com.springsecurityjwt.springsecurityjwt.controller;

import com.springsecurityjwt.springsecurityjwt.dto.JwtAuthenticationResponse;
import com.springsecurityjwt.springsecurityjwt.dto.LoginDTO;
import com.springsecurityjwt.springsecurityjwt.service.impl.UserDetailsServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author zhaomengxia
 * @create 2019/9/23 11:08
 */
@RestController
@RequestMapping(value = "/user/")
public class LoginController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @ApiOperation(value = "用户名密码登陆")
    @PostMapping("/login")
    public JwtAuthenticationResponse login(@RequestBody LoginDTO loginDTO, HttpServletResponse response) throws IOException, ServletException {
        return userDetailsService.login(loginDTO.getUsername(), loginDTO.getPassword(),response);
    }
}
