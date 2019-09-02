package com.springboot_mybatis_module.springboot_mybatis_module.dao;

import com.springboot_mybatis_module.springboot_mybatis_module.dto.StudentDTO;
import com.springboot_mybatis_module.springboot_mybatis_module.model.Sc;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScMapper {
    int insert(Sc record);

    int insertSelective(Sc record);

    int insertBatch(@Param("scs") List<Sc> scs);

    List<StudentDTO> findAllByScore(@Param("score") Integer score);
}