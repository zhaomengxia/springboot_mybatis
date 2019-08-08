package com.springsecurity.springsecurity;

import com.springsecurity.springsecurity.security.model.*;
import com.springsecurity.springsecurity.security.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringsecurityApplicationTests {
	@Resource
	private UserRepository userRepository;
	@Resource
	private RoleRepository roleRepository;
    @Resource
	private UserRoleRepository userRoleRepository;
    @Resource
    private MenuRepository menuRepository;
    @Resource
    private RoleMenuRepository roleMenuRepository;
	@Test
	public void contextLoads() {

		String password="123456";
		String username="admin";

		User user=new User();
		user.setPassword(password);
		user.setUsername(username);
		userRepository.save(user);
	}
	@Test
	public void createRole(){
		Role role=new Role();
		role.setRoleName("管理员");
		roleRepository.save(role);
	}

	@Test
	public void createUserRole(){
		UserRole userRole=new UserRole();
		userRole.setRoleId(2);
		userRole.setUserId(1);
		userRoleRepository.save(userRole);
	}
	@Test
	public void createMenu(){
		Menu menu=new Menu();
		menu.setPermission("所有权限");
		menu.setUrl("/test");
		menuRepository.save(menu);
	}

	@Test
	public void createRoleMenu(){
		RoleMenu roleMenu=new RoleMenu();
		roleMenu.setMenuId(4);
		roleMenu.setRoleId(2);
		roleMenuRepository.save(roleMenu);
	}


}
