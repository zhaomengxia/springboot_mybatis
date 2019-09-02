package com.springboot_mybatis_module.springboot_mybatis_module.dao;

import com.springboot_mybatis_module.springboot_mybatis_module.model.Film;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface FilmMapper {
    int insert(Film record);

    int insertSelective(Film record);
}