package com.springboot_mybatis_module.springboot_mybatis_module.test;

import com.springboot_mybatis_module.springboot_mybatis_module.dao.StudentMapper;
import com.springboot_mybatis_module.springboot_mybatis_module.dao.TeacherMapper;
import com.springboot_mybatis_module.springboot_mybatis_module.model.Student;
import com.springboot_mybatis_module.springboot_mybatis_module.model.Teacher;
import com.springboot_mybatis_module.springboot_mybatis_module.service.TeacherService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhaomengxia
 * @create 2019/8/7 16:49
 */
@MapperScan("com.springboot_mybatis_module.springboot_mybatis_module.dao")
public class Test {

    @Resource
    private static TeacherService teacherService;
    public static void main(String[] args) {
//        // byte
//        System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);
//        System.out.println("包装类：java.lang.Byte");
//        System.out.println("最小值：Byte.MIN_VALUE=" + Byte.MIN_VALUE);
//        System.out.println("最大值：Byte.MAX_VALUE=" + Byte.MAX_VALUE);
//        System.out.println();
//
//        // short
//        System.out.println("基本类型：short 二进制位数：" + Short.SIZE);
//        System.out.println("包装类：java.lang.Short");
//        System.out.println("最小值：Short.MIN_VALUE=" + Short.MIN_VALUE);
//        System.out.println("最大值：Short.MAX_VALUE=" + Short.MAX_VALUE);
//        System.out.println();
//
//        // int
//        System.out.println("基本类型：int 二进制位数：" + Integer.SIZE);
//        System.out.println("包装类：java.lang.Integer");
//        System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);
//        System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE);
//        System.out.println();
//
//        // long
//        System.out.println("基本类型：long 二进制位数：" + Long.SIZE);
//        System.out.println("包装类：java.lang.Long");
//        System.out.println("最小值：Long.MIN_VALUE=" + Long.MIN_VALUE);
//        System.out.println("最大值：Long.MAX_VALUE=" + Long.MAX_VALUE);
//        System.out.println();
//
//        // float
//        System.out.println("基本类型：float 二进制位数：" + Float.SIZE);
//        System.out.println("包装类：java.lang.Float");
//        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);
//        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);
//        System.out.println();
//
//        // double
//        System.out.println("基本类型：double 二进制位数：" + Double.SIZE);
//        System.out.println("包装类：java.lang.Double");
//        System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);
//        System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);
//        System.out.println();
//
//        // char
//        System.out.println("基本类型：char 二进制位数：" + Character.SIZE);
//        System.out.println("包装类：java.lang.Character");
//        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台
//        System.out.println("最小值：Character.MIN_VALUE="
//                + (int) Character.MIN_VALUE);
//        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台
//        System.out.println("最大值：Character.MAX_VALUE="
//                + (int) Character.MAX_VALUE);

       contextLoads();

    }





    public static void contextLoads() {
//		List<Student> students=new ArrayList<>();
//		for (int i=0;i<=200000;i++) {
//			Student student = new Student();
//			student.setSname("男学生"+i);
//			student.setSage(19);
//			student.setSsex("男");
//			students.add(student);
//		}
//		for (int j=0;j<=300000;j++){
//			Student student = new Student();
//			student.setSname("女学生"+j);
//			student.setSage(18);
//			student.setSsex("女");
//			students.add(student);
//		}
//
//		studentMapper.insertBatch(students);
//
//        Student student=new Student();
//        student.setSname("ssss");
//        student.setSage(1);
//        student.setSsex("女");
//        student.setSid(1);
//        studentMapper.insert(student);

        Teacher teacher=new Teacher();
        teacher.setTname("jjjj");
        teacher.setTid(5);
        teacherService.saveOrUpdateTeacher(teacher);
    }
    }
