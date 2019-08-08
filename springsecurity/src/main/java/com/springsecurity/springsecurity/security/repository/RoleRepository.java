package com.springsecurity.springsecurity.security.repository;

import com.springsecurity.springsecurity.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author zhaomengxia
 * @create 2019/8/8 10:40
 *
 * 如果我们想要在业务层等其他地方编写我们的sql语句，那么我们的repository要另外继承一个JpaSpecificationExecutor<T>
 * T代表实体类。这样即可写sql
 */
public interface RoleRepository extends JpaRepository<Role,Long> ,JpaSpecificationExecutor<Role>{

    @Query(value = "select r.* from role r, user_role ur where ur.username = ?1 and ur.role_id = r.role_id", nativeQuery = true)
    public List<Role> findRolesOfUser(String username);


    @Query(value = "select r.* from role r, role_menu rm where rm.menu_id = ?1 and rm.role_id = r.role_id", nativeQuery = true)
    public List<Role> findRolesOfResource(long menuId);
}
