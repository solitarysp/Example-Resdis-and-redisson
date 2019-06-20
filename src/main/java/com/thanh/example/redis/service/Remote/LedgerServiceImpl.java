package com.thanh.example.redis.service.Remote;

import java.util.Objects;

public class LedgerServiceImpl implements LedgerService {
    private String name;

    public LedgerServiceImpl(String name) {
        this.name = name;
    }

    @Override
    public void runService(String name) {
        System.out.println("Chạy service" + (Objects.nonNull(name) ? name : this.name) + " được call từ client");
    }
}
