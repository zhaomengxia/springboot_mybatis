package com.springboot_springdatajpa.springdatajpa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @Author zhaomengxia
 * @create 2019/9/3 10:07
 */
@Data
@Table(name = "user")
@Entity
public class UserModel {

    @Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String avatar;

    private String email;

    private String password;

    private String phone;

    private String realname;

    private String sex;

    private String username;

}
