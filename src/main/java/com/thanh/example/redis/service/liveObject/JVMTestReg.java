package com.thanh.example.redis.service.liveObject;

import com.thanh.example.redis.ConnectRedis;
import com.thanh.example.redis.REntity.Boss;
import com.thanh.example.redis.REntity.Student;
import com.thanh.example.redis.util.Test;
import org.redisson.api.RLiveObjectService;
import org.redisson.api.RedissonClient;

import java.io.IOException;

public class JVMTestReg {
    public static void main(String[] args) throws IOException, InterruptedException {
       // testNoreg();
        testReg();
    }

    static void testNoreg() throws IOException {
        RedissonClient redisson = ConnectRedis.connect();
        Student myObjectJVM2;

        RLiveObjectService service = redisson.getLiveObjectService();

        Test.startTime();
        // nếu không reg trc thì sẽ rất lâu, tầm 440ms, còn nếu reg trc chỉ mất tầm 12
        myObjectJVM2 = service.get(Student.class, "1111");
        Test.endTime();
    }

    static void testReg() throws IOException {
        RedissonClient redisson = ConnectRedis.connect();
        Student myObjectJVM2;

        RLiveObjectService service = redisson.getLiveObjectService();
        Test.startTime();
        service.registerClass(Student.class);
        Test.endTime("Tổng thời gian reg Student mất");
        Test.startTime();
        // nếu không reg trc thì sẽ rất lâu, tầm 440ms, còn nếu reg trc chỉ mất tầm 12
        myObjectJVM2 = service.get(Student.class, "1111");
        Test.endTime();

        Test.startTime();
        service.registerClass(Boss.class);
        Test.endTime("Tổng thời gian reg Boss mất");

    }
}
