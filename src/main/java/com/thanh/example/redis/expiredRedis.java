package com.thanh.example.redis;

import com.thanh.example.redis.entity.Test;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class expiredRedis {
    public static void main(String[] args) {
        RedissonClient redisson = ConnectRedis.connect();
        RBucket<Test> bucket = redisson.getBucket("ObjectBucketExample");
        if (Objects.isNull(bucket.get())) {
            System.out.println(" không tồn tại");
            bucket.set(new Test(122), 50, TimeUnit.SECONDS);
        } else {
            do {
                System.out.println(bucket.get().getUserid());
                System.out.println(bucket.remainTimeToLive());

            } while (Objects.nonNull(bucket.get()));
        }
    }
}
