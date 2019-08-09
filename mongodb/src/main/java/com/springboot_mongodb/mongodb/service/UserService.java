package com.springboot_mongodb.mongodb.service;

import com.springboot_mongodb.mongodb.dao.UserDao;
import com.springboot_mongodb.mongodb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhaomengxia
 * @create 2019/8/9 17:00
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> findAll(){
        List<User> users=userDao.findAll();
        return users;
    }

    public User saveUser(User user){
        return userDao.save(user);
    }
}
