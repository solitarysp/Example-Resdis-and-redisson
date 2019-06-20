package com.thanh.example.redis.service.DistributedExecutorService.Distributedscheduled.cancellationTask;

import org.redisson.api.RedissonClient;
import org.redisson.api.annotation.RInject;

import java.util.concurrent.Callable;

public class RunnableTask implements Callable<Long> {
    @RInject
    private RedissonClient redissonClient;

    @Override
    public Long call() throws Exception {
        System.out.println("dd");

        do {
            if (Thread.currentThread().isInterrupted()) {
                return null;
            }
            System.out.println("dd");
        }while (true);
    }

}