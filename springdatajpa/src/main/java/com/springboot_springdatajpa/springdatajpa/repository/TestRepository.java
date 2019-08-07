package com.springboot_springdatajpa.springdatajpa.repository;

import com.springboot_springdatajpa.springdatajpa.model.TestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author zhaomengxia
 * @create 2019/8/7 9:29
 */
@Repository
public interface TestRepository extends JpaRepository<TestModel,Long> {
}
