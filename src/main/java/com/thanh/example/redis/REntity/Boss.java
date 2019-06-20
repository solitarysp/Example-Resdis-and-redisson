package com.thanh.example.redis.REntity;

import org.redisson.api.annotation.REntity;
import org.redisson.api.annotation.RId;

@REntity
public class Boss {

    @RId
    private String id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
