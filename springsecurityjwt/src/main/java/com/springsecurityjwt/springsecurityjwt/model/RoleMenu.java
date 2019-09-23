package com.springsecurityjwt.springsecurityjwt.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author zhaomengxia
 * @create 2019/8/8 9:44
 */
@Entity
@Table
@Data
public class RoleMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roleMenuId;
    private long roleId;
    private long menuId;
}
