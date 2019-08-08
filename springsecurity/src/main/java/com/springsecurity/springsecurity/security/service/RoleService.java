package com.springsecurity.springsecurity.security.service;

import com.springsecurity.springsecurity.security.model.Role;
import com.springsecurity.springsecurity.security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhaomengxia
 * @create 2019/8/8 13:44
 */
@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAll(String username){
        return roleRepository.findRolesOfUser(username);
    }


}
