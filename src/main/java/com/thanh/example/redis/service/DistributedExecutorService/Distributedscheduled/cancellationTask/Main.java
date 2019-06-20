package com.thanh.example.redis.service.DistributedExecutorService.Distributedscheduled.cancellationTask;

import com.thanh.example.redis.ConnectRedis;
import org.redisson.api.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        RedissonClient redisson = ConnectRedis.connect();

        RScheduledExecutorService executorService = redisson.getExecutorService("RunnableTask");
        executorService.registerWorkers(1);
        RExecutorFuture<Long> future = executorService.submitAsync(new RunnableTask());
        Thread.sleep(5000);
        String taskId = future.getTaskId();
        executorService.cancelTask(taskId);

    }
}
