package com.springboot_mongodb.mongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


/**
 * @Author zhaomengxia
 * @create 2019/8/9 16:53
 */
@Data
@Document(collection = "admin_user")
public class User implements Serializable{


    @Id
    private String _id;

    private String name;

    private int age;


}
