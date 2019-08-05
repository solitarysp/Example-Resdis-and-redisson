package com.thanh.example.redis.service.DistributedExecutorService.Distributedscheduled;

import com.thanh.example.redis.ConnectRedis;
import org.redisson.api.RScheduledExecutorService;
import org.redisson.api.RScheduledFuture;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

public class SchedulingTaskStop {
    public static void main(String[] args) throws InterruptedException {
        RedissonClient redisson = ConnectRedis.connect();
        RScheduledExecutorService executorService = redisson.getExecutorService("RunnableTask");
      //  executorService.shutdown();
        // xóa tất cả các thread đang đợi delay
          executorService.delete();
        System.out.println("ok");
    }
}
