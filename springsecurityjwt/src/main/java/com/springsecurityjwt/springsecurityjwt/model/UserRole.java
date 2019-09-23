package com.springsecurityjwt.springsecurityjwt.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author zhaomengxia
 * @create 2019/8/8 9:43
 */
@Entity
@Table(name = "user_role")
@Data
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userRoleId;
    private long userId;
    private long roleId;

//    @OneToMany
//    @JoinColumn
//    private List<Role> roles;
}
