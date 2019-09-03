package com.springboot_springdatajpa.springdatajpa.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author zhaomengxia
 * @create 2019/9/3 10:07
 */
@Data
@Entity
@Table(name = "user_role")
public class UserRoleModel {
    @Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userRoleId;

    private Long roleId;

    private Long userId;
}
