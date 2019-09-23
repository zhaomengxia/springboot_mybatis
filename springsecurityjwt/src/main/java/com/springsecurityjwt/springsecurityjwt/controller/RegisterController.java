package com.springsecurityjwt.springsecurityjwt.controller;

import com.springsecurityjwt.springsecurityjwt.exception.UnifiedException;
import com.springsecurityjwt.springsecurityjwt.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhaomengxia
 * @create 2019/9/20 16:03
 */
@RestController
@RequestMapping("/user")
@Api(value = "注册用户",description ="注册用户" )
public class RegisterController extends BaseController{
//    @Autowired
//    private PasswordEncoder passwordEncoder;
    /**
     * 注册用户 默认开启白名单
     * @param user
     */
    @ApiOperation(value = "注册用户")
    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        User bizUser = userRepository.findAllByUsername(user.getUsername());
        if(null != bizUser){
            throw new UnifiedException("用户已经存在");
        }
        /*user.setPassword(DigestUtils.md5DigestAsHex((user.getPassword()).getBytes()));*/
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
