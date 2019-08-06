package com.springboot_springdatajpa.springdatajpa.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author zhaomengxia
 * @create 2019/8/6 20:48
 */
@Table(name = "test_model")
@Entity
@Data
public class TestModel implements Serializable {
    @Id
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String code;
    private long age;
    private String gender;
    private String gradution;
}
