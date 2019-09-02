package com.springboot_mybatis_module.springboot_mybatis_module.dao;

import com.springboot_mybatis_module.springboot_mybatis_module.model.Course;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface CourseMapper {
    int insert(Course record);

    int insertSelective(Course record);
}