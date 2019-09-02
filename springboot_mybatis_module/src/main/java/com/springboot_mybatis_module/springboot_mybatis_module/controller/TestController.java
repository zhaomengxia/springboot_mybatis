package com.springboot_mybatis_module.springboot_mybatis_module.controller;

import com.springboot_mybatis_module.springboot_mybatis_module.model.Student;
import com.springboot_mybatis_module.springboot_mybatis_module.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhaomengxia
 * @create 2019/8/6 17:47
 */
@Api(description = "测试")
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    public StudentService studentService;

    @GetMapping(value = "/test")
    @ApiOperation(value = "hgghss")
    public String test(){
        System.out.println("uuuu");
        return "wwsss";
    }


    @PostMapping(value = "/saveOrUpdate")
    @ApiOperation(value = "新增或则修改学生信息")
    public boolean saveOrUpdate(){
        List<Student> students=new ArrayList<>();
        for (int i=0;i<=200000;i++) {
            Student student = new Student();
            student.setSname("男学生"+i);
            student.setSage(19);
            student.setSsex("男");
            students.add(student);
        }
        for (int j=0;j<=300000;j++){
            Student student = new Student();
            student.setSname("女学生"+j);
            student.setSage(18);
            student.setSsex("女");
            students.add(student);
        }

        studentService.saveOrUpdate(students);
        return true;
    }
}
