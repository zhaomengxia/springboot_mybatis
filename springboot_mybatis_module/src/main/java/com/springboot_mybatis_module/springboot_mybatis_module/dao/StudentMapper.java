package com.springboot_mybatis_module.springboot_mybatis_module.dao;

import com.springboot_mybatis_module.springboot_mybatis_module.model.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
//@Mapper
public interface StudentMapper {
    int insert(Student record);

    int insertSelective(Student record);

    int insertBatch(List<Student> students);
}