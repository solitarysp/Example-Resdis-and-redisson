package com.thanh.example.redis.service.DistributedExecutorService.Distributedscheduled;

import com.thanh.example.redis.ConnectRedis;
import org.redisson.api.RScheduledExecutorService;
import org.redisson.api.RScheduledFuture;
import org.redisson.api.RedissonClient;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class SchedulingTask {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        RedissonClient redisson = ConnectRedis.connect();
        RScheduledExecutorService executorService = redisson.getExecutorService("RunnableTask");
        executorService.registerWorkers(1);
        RScheduledFuture<Long> future = executorService.schedule(new CallableTask(), 10, TimeUnit.SECONDS);
        Long result = future.get();

    }
}
