package com.springboot_mybatis_module.springboot_mybatis_module.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot_mybatis_module.springboot_mybatis_module.dao.StudentMapper;
import com.springboot_mybatis_module.springboot_mybatis_module.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhaomengxia
 * @create 2019/9/2 14:02
 */
@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public int saveOrUpdate(List<Student>students){
        return studentMapper.insertBatch(students);
    }

    public PageInfo<Student> select(){
        Page<Student> students= PageHelper.startPage(1,2);
        List<Student> students1=studentMapper.findAll();
        PageInfo<Student> pageInfo=new PageInfo<>(students1);
        return pageInfo;
    }
}
