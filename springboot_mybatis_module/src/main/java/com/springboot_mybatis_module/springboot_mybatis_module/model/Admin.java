package com.springboot_mybatis_module.springboot_mybatis_module.model;

public class Admin {
    private Integer id;

    private String name;

    private String realname;

    private String password;

    private String phone;

    private String address;

    public Admin(Integer id, String name, String realname, String password, String phone, String address) {
        this.id = id;
        this.name = name;
        this.realname = realname;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    public Admin() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}