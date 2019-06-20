package com.thanh.example.redis.service.Remote;

import com.thanh.example.redis.ConnectRedis;
import org.redisson.api.RRemoteService;
import org.redisson.api.RedissonClient;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        RedissonClient redisson = ConnectRedis.connect();

        //Remote client
        RRemoteService remoteServiceClient = redisson.getRemoteService();
        LedgerService ledgerService
                = remoteServiceClient.get(LedgerService.class);
        ledgerService.runService("test 2");
    }
}
