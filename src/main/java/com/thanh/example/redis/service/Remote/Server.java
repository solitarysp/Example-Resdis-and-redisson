package com.thanh.example.redis.service.Remote;

import com.thanh.example.redis.ConnectRedis;
import org.redisson.api.RRemoteService;
import org.redisson.api.RedissonClient;

import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException {
        RedissonClient redisson = ConnectRedis.connect();

        RRemoteService remoteService = redisson.getRemoteService();
        LedgerServiceImpl ledgerServiceImpl = new LedgerServiceImpl(Server.class.getName());

        remoteService.register(LedgerService.class, ledgerServiceImpl);
    }
}
