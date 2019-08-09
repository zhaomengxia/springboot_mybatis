package com.springboot_mongodb.mongodb;

import com.springboot_mongodb.mongodb.dao.UserDao;
import com.springboot_mongodb.mongodb.model.User;
import com.springboot_mongodb.mongodb.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {

		User user=new User();

		user.setAge(1);

		user.setName("test");

		userService.saveUser(user);

	}
	@Test
	public void findAll(){
		List<User> users= userService.findAll();
		System.out.println(users.size());
	}

}
