package com.springboot_mybatis_module.springboot_mybatis_module.controller;

import com.springboot_mybatis_module.springboot_mybatis_module.dto.StudentDTO;
import com.springboot_mybatis_module.springboot_mybatis_module.model.Sc;
import com.springboot_mybatis_module.springboot_mybatis_module.model.Student;
import com.springboot_mybatis_module.springboot_mybatis_module.model.Teacher;
import com.springboot_mybatis_module.springboot_mybatis_module.service.ScService;
import com.springboot_mybatis_module.springboot_mybatis_module.service.StudentService;
import com.springboot_mybatis_module.springboot_mybatis_module.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    public TeacherService teacherService;

    @Autowired
    public ScService scService;

    @GetMapping(value = "/test")
    @ApiOperation(value = "hgghss")
    public String test() {
        System.out.println("uuuu");
        return "wwsss";
    }


    @PostMapping(value = "/saveOrUpdateAll")
    @ApiOperation(value = "测试批量新增或则修改教师信息")
    public boolean saveOrUpdateAll() {

        List<Teacher> teacherlist = new ArrayList<>();

        for (int i = 0; i <= 10000; i++) {

            Teacher teacher = new Teacher();

            teacher.setTname("教师" + i);

            teacherlist.add(teacher);
        }
        teacherService.saveOrupdateAll(teacherlist);
        return true;
    }


    @PostMapping(value = "/saveOrUpdate")
    @ApiOperation(value = "新增或则修改学生信息")
    public boolean saveOrUpdate() {
        List<Student> students = new ArrayList<>();
        for (int i = 20001; i <= 100000; i++) {
            Student student = new Student();
            student.setSname("女学生" + i);
            student.setSage(18);
            student.setSsex("女");
            students.add(student);
        }
//        for (int j=0;j<=300000;j++){
//            Student student = new Student();
//            student.setSname("女学生"+j);
//            student.setSage(18);
//            student.setSsex("女");
//            students.add(student);
//        }

        studentService.saveOrUpdate(students);
        return true;
    }


    @PostMapping(value = "/saveOrUpdateSc")
    @ApiOperation(value = "批量新增或则修改学生课程成绩")
    public boolean saveOrUpdateSc(){

        List<Sc> scs=new ArrayList<>();

        for (int i = 10000; i <100000 ; i++) {


            for (int j = 1; j <=4 ; j++) {

                Sc sc=new Sc();

                sc.setSid(i);
                sc.setCid(j);
                sc.setScore(101-j);
                scs.add(sc);
            }

        }

        scService.saveOrUpdateAll(scs);

        return true;
    }


    @GetMapping(value = "findAllByScore")
    @ApiOperation(value = "查找课程为物理的成绩为100分的学生信息")
    public List<StudentDTO> findAllByScore(@RequestParam("score") Integer score){

        return scService.findAll(score);

    }

}
