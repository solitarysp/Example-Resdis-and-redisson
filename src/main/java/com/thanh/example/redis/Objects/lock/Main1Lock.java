package com.thanh.example.redis.Objects.lock;

import com.thanh.example.redis.ConnectRedis;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

public class Main1Lock {
    public static void main(String[] args) throws InterruptedException {
        RedissonClient redisson = ConnectRedis.connect();
        RLock test = redisson.getLock("TestLock");
        System.out.println(test.tryLock());;

    }
}
