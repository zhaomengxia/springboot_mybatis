package com.springboot_springdatajpa.springdatajpa.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author zhaomengxia
 * @create 2019/9/3 10:07
 */
@Data
@Table(name = "role")
@Entity
public class RoleModel {
    @Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;
    private String roleName;
}
