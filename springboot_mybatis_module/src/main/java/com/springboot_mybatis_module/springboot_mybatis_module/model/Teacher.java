package com.springboot_mybatis_module.springboot_mybatis_module.model;

public class Teacher {
    private Integer tid;

    private String tname;

    public Teacher(Integer tid, String tname) {
        this.tid = tid;
        this.tname = tname;
    }

    public Teacher() {
        super();
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }
}