package com.thanh.example.redis.service.DistributedExecutorService.Distributedscheduled;

import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.api.annotation.RInject;

import java.io.Serializable;
import java.util.concurrent.Callable;

public class CallableTask implements Callable, Serializable {
    @RInject
    private RedissonClient redissonClient;


    @Override
    public Long call() throws Exception {
        System.out.println("dđ");
        RMap<String, Integer> map = redissonClient.getMap("myMap");
        Long result = 1l;
        for (Integer value : map.values()) {
            result += value;
        }
        return result;
    }
}
