package com.springboot_mybatis_module.springboot_mybatis_module.dao;

import com.springboot_mybatis_module.springboot_mybatis_module.model.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//@Mapper
public interface TeacherMapper {
    int insert(Teacher record);

    int insertSelective(Teacher record);

    int insertBatch(@Param("teachers") List<Teacher> teachers);
}