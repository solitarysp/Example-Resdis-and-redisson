package com.thanh.example.redis.Objects.lock;

import com.thanh.example.redis.ConnectRedis;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

public class MainRead {
    public static void main(String[] args) throws InterruptedException {
        RedissonClient redisson = ConnectRedis.connect();
        RLock test = redisson.getLock("TestLock");
        do {

            Thread.sleep(1000);
        }while (true);
    }
}
