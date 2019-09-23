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
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long menuId;
    private String url;
    private String permission;
    /**
     * 这种方法简化了使用，但并没有提升效率，而是有的时候我们不需要使用关联数据，而
     * 只用到menu本身的时候，他们从数据库中把无用的数据取出来。这样不仅浪费了空间话降低了效率。
     */
//    @OneToMany
//    @JoinColumn
//    private List<Role> roles;
}
