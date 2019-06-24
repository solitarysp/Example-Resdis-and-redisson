package com.thanh.example.redis.Collections.map;

import com.thanh.example.redis.ConnectRedis;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;

public class MainMultiMap {
    public static void main(String[] args) {
        RedissonClient redisson = ConnectRedis.connect();
        RMap<Integer, String> testCollectionsMap = redisson.getMap("testCollectionsMapLock");
        String v = testCollectionsMap.get(1);
        System.out.println(v);
    }
}
