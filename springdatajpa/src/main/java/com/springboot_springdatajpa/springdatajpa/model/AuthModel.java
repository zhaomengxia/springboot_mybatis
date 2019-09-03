package com.springboot_springdatajpa.springdatajpa.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zhaomengxia
 * @create 2019/9/3 14:38
 */
@Data
public class AuthModel implements Serializable{

    private String authName;

    private String authUrl;

    private String authUniqueMark;

    private Date createTime;

    private String methodType;
}
