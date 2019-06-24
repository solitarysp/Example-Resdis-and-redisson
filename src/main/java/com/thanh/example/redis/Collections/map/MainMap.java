package com.thanh.example.redis.Collections.map;

import com.thanh.example.redis.ConnectRedis;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;

public class MainMap {
    public static void main(String[] args) {
        RedissonClient redisson = ConnectRedis.connect();
        RMap<Integer, String> testCollectionsMap = redisson.getMap("testCollectionsMap");
        testCollectionsMap.put(1, "test");

        // nếu chưa tồn tại thì mới put lên, có rồi sẽ không push lên
        testCollectionsMap.putIfAbsent(1, "test khong co");

        testCollectionsMap.fastRemove(2);
        testCollectionsMap.putIfAbsent(2, "test khong co");

        // put bất đồng bộ có kết quả của value được push lên
        testCollectionsMap.putAsync(3, "3 test khong co").handle((s, throwable) -> {
            System.out.println("put thành công | " + s);
            return true;
        });
        // put bất đồng bộ không có kết quả của value được push lên.
        testCollectionsMap.fastPutAsync(3, "3 test khong co1").handle((s, throwable) -> {
            System.out.println("put thành công | " + s);
            return true;
        });

        testCollectionsMap = redisson.getMap("testCollectionsMap");
        System.out.println(testCollectionsMap.values());
    }

}
