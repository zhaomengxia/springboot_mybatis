package com.springboot_springdatajpa.springdatajpa.repository;

import com.springboot_springdatajpa.springdatajpa.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author zhaomengxia
 * @create 2019/9/3 10:19
 */
@Repository
public interface UserRepository extends JpaRepository<UserModel,Long>{
    UserModel findByUsername(String userName);
}
