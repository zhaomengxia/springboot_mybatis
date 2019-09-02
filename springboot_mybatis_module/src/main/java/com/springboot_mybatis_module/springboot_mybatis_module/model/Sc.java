package com.springboot_mybatis_module.springboot_mybatis_module.model;

public class Sc {
    private Integer sid;

    private Integer cid;

    private Integer score;

    public Sc(Integer sid, Integer cid, Integer score) {
        this.sid = sid;
        this.cid = cid;
        this.score = score;
    }

    public Sc() {
        super();
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}