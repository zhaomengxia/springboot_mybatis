package com.springboot_mybatis_module.springboot_mybatis_module.service;

import com.springboot_mybatis_module.springboot_mybatis_module.dao.TeacherMapper;
import com.springboot_mybatis_module.springboot_mybatis_module.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author zhaomengxia
 * @create 2019/9/2 10:30
 */
@Service
public class TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    public int saveOrUpdateTeacher(Teacher teacher){
        return teacherMapper.insert(teacher);
    }
}
