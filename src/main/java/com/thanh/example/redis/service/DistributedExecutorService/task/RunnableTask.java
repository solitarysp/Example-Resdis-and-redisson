package com.thanh.example.redis.service.DistributedExecutorService.task;

import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.redisson.api.annotation.RInject;

public class RunnableTask implements Runnable  {
    @RInject
    private RedissonClient redissonClient;

    private long param;

    public RunnableTask() {
    }

    public RunnableTask(long param) {
        this.param= param;
    }

    @Override
    public void run() {
        RAtomicLong atomic = redissonClient.getAtomicLong("RunnableTaskLog");
        atomic.addAndGet(param);
        System.out.println("RunnableTask");
    }
}
