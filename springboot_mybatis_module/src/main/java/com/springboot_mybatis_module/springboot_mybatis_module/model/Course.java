package com.springboot_mybatis_module.springboot_mybatis_module.model;

public class Course {
    private Integer cid;

    private String cname;

    private Integer tid;

    public Course(Integer cid, String cname, Integer tid) {
        this.cid = cid;
        this.cname = cname;
        this.tid = tid;
    }

    public Course() {
        super();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }
}