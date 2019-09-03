package com.springboot_mybatis_module.springboot_mybatis_module.dao;

import com.github.pagehelper.Page;
import com.springboot_mybatis_module.springboot_mybatis_module.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
//@Mapper
public interface StudentMapper {
    int insert(Student record);

    int insertSelective(Student record);

    int insertBatch(@Param("students") List<Student> students);

    List<Student> findAll();

}