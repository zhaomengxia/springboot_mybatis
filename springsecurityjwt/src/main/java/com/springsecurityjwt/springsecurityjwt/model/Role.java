package com.springsecurityjwt.springsecurityjwt.model;

import lombok.Data;
import javax.persistence.*;

/**
 * @Author zhaomengxia
 * @create 2019/8/8 9:43
 */
@Entity
@Table(name = "role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roleId;
    private String roleName;
}
