package com.thanh.example.redis.service.liveObject;

import com.thanh.example.redis.ConnectRedis;
import com.thanh.example.redis.REntity.Clazz;
import com.thanh.example.redis.REntity.Student;
import org.redisson.api.RLiveObjectService;
import org.redisson.api.RedissonClient;

import java.io.IOException;

public class JVM1 {
    public static void main(String[] args) throws IOException {
        RedissonClient redisson = ConnectRedis.connect();
        RLiveObjectService service = redisson.getLiveObjectService();
        Student myObject = new Student();
        myObject.setId("1111");
        myObject.setName("ddcc");
        myObject.setClazz(new Clazz("12a7"));
        service.merge(myObject);
        System.out.println(myObject.toString());
    }
}
