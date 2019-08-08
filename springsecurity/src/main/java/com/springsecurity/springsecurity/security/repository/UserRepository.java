package com.springsecurity.springsecurity.security.repository;

import com.springsecurity.springsecurity.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhaomengxia
 * @create 2019/8/8 10:04
 */
@Repository
public interface UserRepository  extends JpaRepository<User,Long>{
    List<User> findAllByUsername(String userName);
}
