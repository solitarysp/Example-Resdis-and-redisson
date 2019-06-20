package com.thanh.example.redis.service.liveObject;

import com.thanh.example.redis.ConnectRedis;
import com.thanh.example.redis.REntity.Student;
import com.thanh.example.redis.util.Test;
import org.redisson.api.RLiveObjectService;
import org.redisson.api.RedissonClient;

import java.io.IOException;

public class JVM3 {
    public static void main(String[] args) throws IOException, InterruptedException {
        RedissonClient redisson = ConnectRedis.connect();

        RLiveObjectService service = redisson.getLiveObjectService();
        Student myObjectJVM2;
        // check is reg
      //  service.registerClass(Student.class);
        System.out.println(service.isClassRegistered(Student.class));
        // current state of myObject is now cleared and attached to Redis
        Test.startTime();
        // nếu không reg trc thì sẽ rất lâu, tầm 440ms, còn nếu reg trc chỉ mất tầm 12
        myObjectJVM2 = service.get(Student.class, "1111");
        Test.endTime();
        do {
            System.out.println(myObjectJVM2.getName());
            service.isClassRegistered(Student.class);
            Thread.sleep(1000);
        } while (true);
    }
}
