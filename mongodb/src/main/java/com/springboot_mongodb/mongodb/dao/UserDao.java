package com.springboot_mongodb.mongodb.dao;

import com.springboot_mongodb.mongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * @Author zhaomengxia
 * @create 2019/8/9 16:56
 */
@Repository
public interface UserDao extends MongoRepository<User,Long> {
}
