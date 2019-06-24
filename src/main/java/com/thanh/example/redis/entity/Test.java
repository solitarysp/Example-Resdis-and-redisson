package com.thanh.example.redis.entity;


import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "test")
public class Test implements Serializable {
    private Integer userid;
    private String name;

    public Test() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Test(Integer userid) {
        this.userid = userid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

}
