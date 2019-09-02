package com.springboot_mybatis_module.springboot_mybatis_module;

import com.springboot_mybatis_module.springboot_mybatis_module.dao.StudentMapper;
import com.springboot_mybatis_module.springboot_mybatis_module.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisModuleApplicationTests {
	@Autowired
	private StudentMapper studentMapper;

	@Test
	public void contextLoads() {
		Student student=new Student();
		student.setSname("sddd");
		student.setSage(1);
		student.setSsex("女");
		studentMapper.insert(student);
	}

}
