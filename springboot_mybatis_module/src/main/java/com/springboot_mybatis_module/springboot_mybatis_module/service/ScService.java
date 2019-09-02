package com.springboot_mybatis_module.springboot_mybatis_module.service;

import com.springboot_mybatis_module.springboot_mybatis_module.dao.ScMapper;
import com.springboot_mybatis_module.springboot_mybatis_module.dto.StudentDTO;
import com.springboot_mybatis_module.springboot_mybatis_module.model.Sc;
import com.springboot_mybatis_module.springboot_mybatis_module.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhaomengxia
 * @create 2019/9/2 15:27
 */
@Service
public class ScService {

    @Autowired
    private ScMapper scMapper;


    public int saveOrUpdateAll(List<Sc> scs){
        return scMapper.insertBatch(scs);
    }


    public List<StudentDTO> findAll(Integer score){

        List<StudentDTO> studentDTOS=scMapper.findAllByScore(score);
        return studentDTOS;

    }

}
