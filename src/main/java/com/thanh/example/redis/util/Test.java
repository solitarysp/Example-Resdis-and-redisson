package com.thanh.example.redis.util;

public class Test {
    private static Long time;

    public synchronized static void startTime() {
        time = System.currentTimeMillis();
    }

    public synchronized static void endTime() {
        System.out.println(System.currentTimeMillis() - time);
    }

    public synchronized static void endTime(String msg) {
        System.out.println(msg);
        System.out.println(System.currentTimeMillis() - time);
    }
}
