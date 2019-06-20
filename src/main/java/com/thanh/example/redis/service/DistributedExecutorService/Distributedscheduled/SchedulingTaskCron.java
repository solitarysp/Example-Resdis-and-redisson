package com.thanh.example.redis.service.DistributedExecutorService.Distributedscheduled;

import com.thanh.example.redis.ConnectRedis;
import org.redisson.api.CronSchedule;
import org.redisson.api.RScheduledExecutorService;
import org.redisson.api.RedissonClient;

import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.ExecutionException;

public class SchedulingTaskCron {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        RedissonClient redisson = ConnectRedis.connect();
        RScheduledExecutorService executorService = redisson.getExecutorService("RunnableTask");

        executorService.registerWorkers(1);
        executorService.schedule(new RunnableTask(), CronSchedule.of("40 13 * * * ?"));
        executorService.registerWorkers(1);

        executorService.schedule(new RunnableTask(), CronSchedule.dailyAtHourAndMinute(13, 34));
        executorService.registerWorkers(1);

        executorService.schedule(new RunnableTask(), CronSchedule.dailyAtHourAndMinute(10, 5));
        executorService.registerWorkers(1);

        executorService.schedule(new RunnableTask(), CronSchedule.weeklyOnDayAndHourAndMinute(12, 4, Calendar.MONDAY, Calendar.FRIDAY));
    }
}
