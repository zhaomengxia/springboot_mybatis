package com.springboot_springdatajpa.springdatajpa.repository;

import com.springboot_springdatajpa.springdatajpa.model.UserRoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author zhaomengxia
 * @create 2019/9/3 11:31
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleModel,Long>{
}
