package com.thanh.example.redis.service.liveObject;

import com.thanh.example.redis.ConnectRedis;
import com.thanh.example.redis.REntity.Student;
import org.redisson.api.RLiveObjectService;
import org.redisson.api.RedissonClient;

import java.io.IOException;

public class JVM2 {
    public static void main(String[] args) throws IOException {
        RedissonClient redisson = ConnectRedis.connect();

        RLiveObjectService service = redisson.getLiveObjectService();

        Student myObjectJVM2;
// current state of myObject is now cleared and attached to Redis
        myObjectJVM2 = service.get(Student.class, "1111");
        String clone = myObjectJVM2.getName();
        do {
            System.out.println(clone);

        } while (true);

    }
}
