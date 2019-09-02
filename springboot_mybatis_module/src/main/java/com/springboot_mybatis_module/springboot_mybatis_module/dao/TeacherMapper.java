package com.springboot_mybatis_module.springboot_mybatis_module.dao;

import com.springboot_mybatis_module.springboot_mybatis_module.model.Teacher;
import org.apache.ibatis.annotations.Mapper;
//@Mapper
public interface TeacherMapper {
    int insert(Teacher record);

    int insertSelective(Teacher record);
}