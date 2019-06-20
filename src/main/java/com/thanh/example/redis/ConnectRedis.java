package com.thanh.example.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConnectRedis {
    public static RedissonClient connect() throws IOException {


        return Redisson.create(createConfig());
    }

    public static Config createConfig() throws IOException {
        Properties caches = new Properties();
        caches.load(new FileInputStream(System.getProperty("user.dir") + File.separator + "conf" + File.separator + "cache.properties"));
        // load cache configuration
        String cacheMode = caches.getProperty("cache.mode");
        String redisAddress = caches.getProperty("redis.address");
        String redisPassword = caches.getProperty("redis.password");
        int redisTimeout = Integer.parseInt(caches.getProperty("redis.response.timeout"));
        int redisConnectionTimeout = Integer.parseInt(caches.getProperty("redis.connection.timeout"));
        int redisIdleConnectionTimeout = Integer.parseInt(caches.getProperty("redis.connection.idle.time"));
        int redisConnectionMinimumIdleSize = Integer.parseInt(caches.getProperty("redis.connection.min"));
        int redisConnectionPoolSize = Integer.parseInt(caches.getProperty("redis.connection.max"));

        // redis
        Config redissonConfig = new Config();
        redissonConfig.setThreads(5).useSingleServer()
                .setConnectTimeout(redisConnectionTimeout)
                .setTimeout(redisTimeout)
                .setIdleConnectionTimeout(redisIdleConnectionTimeout)
                .setConnectionMinimumIdleSize(redisConnectionMinimumIdleSize)
                .setConnectionPoolSize(redisConnectionPoolSize)
                .setAddress(redisAddress)
                .setPassword(redisPassword);
        return redissonConfig;
    }
}
