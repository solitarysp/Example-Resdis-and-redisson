package com.thanh.example.redis.service.DistributedExecutorService.Distributedscheduled;

import com.thanh.example.redis.ConnectRedis;
import org.redisson.api.RScheduledExecutorService;
import org.redisson.api.RedissonClient;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class SchedulingTask {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        RedissonClient redisson = ConnectRedis.connect();
        RScheduledExecutorService executorService = redisson.getExecutorService("RunnableTask");
        executorService.delete();
        executorService.registerWorkers(1);
        executorService.schedule(new test(),  10, TimeUnit.SECONDS);
        System.out.println("d");
        System.out.println("d");
        System.out.println("d");
        System.out.println("d");
        System.out.println("d");
        System.out.println("d");
        System.out.println("d");
        System.out.println("d");
        System.out.println("d");
        System.out.println("d");
        System.out.println("d");
        System.out.println("d");
        System.out.println("d");
        System.out.println("d");
        System.out.println("d");
        System.out.println("d");
        System.out.println("d");
        System.out.println("d");
        System.out.println("d");
        System.out.println("d");
        System.out.println("d");
        System.out.println("d");

    }

}
class test implements Runnable, Serializable {

    @Override
    public void run() {
        System.out.println("cc");
    }
}
