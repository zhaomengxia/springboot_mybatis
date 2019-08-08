package com.springsecurity.springsecurity.security.service;

import com.springsecurity.springsecurity.security.model.User;
import com.springsecurity.springsecurity.security.model.UserDetailsImpl;
import com.springsecurity.springsecurity.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author zhaomengxia
 * @create 2019/8/8 10:13
 *
 * 用户接收了用户输入的用户名，交给UserService，他根据用户名去数据库中取用户的信息，
 * 封装到实体类User的实例中，然后使用User实例，再利用RoleService查出该User对应的roles，
 * 构造一个UserDetailsImpl的对象，把这个对象返回给程序
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;

    @Transactional
    public List<User>  getAllUser(){
        return userRepository.findAll();
    }
    @Transactional
    public List<User> getByUsername(String username){
        return userRepository.findAllByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=getByUsername(s).get(0);
        if (user==null){
            throw new UsernameNotFoundException("没有该用户");
        }
        return new UserDetailsImpl(user,roleService.getAll(user.getUsername()));
    }
}
