package com.springsecurity.springsecurity.security.service;

import com.springsecurity.springsecurity.security.model.Menu;
import com.springsecurity.springsecurity.security.model.Role;
import com.springsecurity.springsecurity.security.repository.MenuRepository;
import com.springsecurity.springsecurity.security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhaomengxia
 * @create 2019/8/8 14:56
 */
@Service
public class MenuService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private MenuRepository menuRepository;
    public List<Role> getAll(long menuId){
        return roleRepository.findRolesOfResource(menuId);
    }

    public Menu getMenuByUrl(String url){
        return menuRepository.findByUrl(url);
    }
}
