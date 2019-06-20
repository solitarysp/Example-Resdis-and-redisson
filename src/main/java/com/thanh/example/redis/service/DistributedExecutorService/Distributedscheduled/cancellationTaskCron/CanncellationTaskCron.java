package com.thanh.example.redis.service.DistributedExecutorService.Distributedscheduled.cancellationTaskCron;

import com.thanh.example.redis.ConnectRedis;
import org.redisson.api.CronSchedule;
import org.redisson.api.RScheduledExecutorService;
import org.redisson.api.RScheduledFuture;
import org.redisson.api.RedissonClient;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class CanncellationTaskCron {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        RedissonClient redisson = ConnectRedis.connect();
        RScheduledExecutorService executorService = redisson.getExecutorService("RunnableTask");

        executorService.registerWorkers(1);
        RScheduledFuture<?> future =  executorService.scheduleAsync(new RunnableTask(), CronSchedule.of("40 13 * * * ?"));
        Thread.sleep(5000);
        String taskId = future.getTaskId();
        executorService.cancelTask(taskId);
    }
}
