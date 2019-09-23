package com.springsecurityjwt.springsecurityjwt.repository;

import com.springsecurityjwt.springsecurityjwt.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author zhaomengxia
 * @create 2019/8/8 10:49
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu,Long> {

    Menu findByUrl(String url);
}
