package com.springsecurity.springsecurity.security.repository;

import com.springsecurity.springsecurity.security.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author zhaomengxia
 * @create 2019/8/8 10:46
 */
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
}
