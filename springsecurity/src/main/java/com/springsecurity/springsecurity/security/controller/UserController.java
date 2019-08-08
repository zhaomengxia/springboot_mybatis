package com.springsecurity.springsecurity.security.controller;

import com.springsecurity.springsecurity.security.model.User;
import com.springsecurity.springsecurity.security.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author zhaomengxia
 * @create 2019/8/8 10:05
 */
@RestController
@RequestMapping(value = "/test")
public class UserController {
    @Resource
    private UserRepository userRepository;

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveUser(User user){
        return ResponseEntity.ok(userRepository.save(user));
    }
}
