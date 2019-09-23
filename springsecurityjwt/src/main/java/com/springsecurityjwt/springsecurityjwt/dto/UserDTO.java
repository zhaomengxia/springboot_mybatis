package com.springsecurityjwt.springsecurityjwt.dto;

import lombok.Data;

/**
 * @Author zhaomengxia
 * @create 2019/9/23 10:03
 */
@Data
public class UserDTO {
    private long userId;
    private String username;
    private String realname;
    private String avatar;
    private String phone;
    private String email;
    private String sex;
    private String authorities;
}
