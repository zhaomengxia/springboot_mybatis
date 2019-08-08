package com.springsecurity.springsecurity.security.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author zhaomengxia
 * @create 2019/8/8 9:43
 */
@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    private String username;
    private String password;
    private String realname;
    private String avatar;
    private String phone;
    private String email;
    private String sex;
}
