package com.springsecurityjwt.springsecurityjwt.repository;

import com.springsecurityjwt.springsecurityjwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



/**
 * @Author zhaomengxia
 * @create 2019/8/8 10:04
 */
@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
    User findAllByUsername(String userName);
}
