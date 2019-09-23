package com.springsecurityjwt.springsecurityjwt.repository;


import com.springsecurityjwt.springsecurityjwt.model.RoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author zhaomengxia
 * @create 2019/8/8 10:50
 */
public interface RoleMenuRepository extends JpaRepository<RoleMenu,Long> {
}
