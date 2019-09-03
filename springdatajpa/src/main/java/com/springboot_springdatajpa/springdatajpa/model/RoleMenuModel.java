package com.springboot_springdatajpa.springdatajpa.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author zhaomengxia
 * @create 2019/9/3 10:08
 */
@Data
@Table(name = "role_menu")
@Entity
public class RoleMenuModel {
    @Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long RoleMenuId;
    private Long menuId;
    private Long roleId;
}
