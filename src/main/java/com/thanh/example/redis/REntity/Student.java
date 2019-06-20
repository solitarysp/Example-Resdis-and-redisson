package com.thanh.example.redis.REntity;

import org.redisson.api.annotation.REntity;
import org.redisson.api.annotation.RId;
import org.redisson.api.annotation.RObjectField;
import org.redisson.codec.SerializationCodec;
import org.redisson.codec.SnappyCodec;

@REntity
public class Student {

    @RId
    private String id;
    @RObjectField(codec = SerializationCodec.class)
    private String name;
    private Clazz clazz;

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

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }
}
