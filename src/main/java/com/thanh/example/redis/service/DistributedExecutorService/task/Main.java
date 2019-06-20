package com.thanh.example.redis.service.DistributedExecutorService.task;

import com.thanh.example.redis.ConnectRedis;
import org.redisson.api.RScheduledExecutorService;
import org.redisson.api.RedissonClient;

import java.io.IOException;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        RedissonClient redisson = ConnectRedis.connect();
        RScheduledExecutorService executorService = redisson.getExecutorService("CallableTask");
        executorService.registerWorkers(1);
        ScheduledFuture<Long> future = executorService.schedule(new CallableTask(), 1, TimeUnit.SECONDS);
        Long result = future.get();
        System.out.println(result);

        RScheduledExecutorService executorServiceRunnableTask = redisson.getExecutorService("RunnableTask");
        executorServiceRunnableTask.registerWorkers(1);
        executorServiceRunnableTask.schedule(new RunnableTask(123), 1, TimeUnit.SECONDS);
    }
}
