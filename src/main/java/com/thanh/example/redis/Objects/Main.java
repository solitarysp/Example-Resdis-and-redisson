package com.thanh.example.redis.Objects;

import com.thanh.example.redis.ConnectRedis;
import com.thanh.example.redis.entity.Test;
import org.redisson.api.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        RedissonClient redisson = ConnectRedis.connect();

        List<Integer> listRoomID = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listRoomID.add(i);
        }


        //With object
        RBucket<Test> bucket = redisson.getBucket("ObjectBucketExample");
        bucket.set(new Test(122));
        bucket = redisson.getBucket("ObjectBucketExample");
        Test ledger = bucket.get();
        System.out.println(ledger.getUserid());

        // with list
        RBucket<List<Integer>> bucketList = redisson.getBucket("BucketListExample");
        bucketList.set(listRoomID);
        bucketList = redisson.getBucket("BucketListExample");
        List<Integer> bucketListobject = bucketList.get();
        System.out.println(bucketListobject);

        // AtomicLong, chỉ lưu các giá trị long
        RAtomicLong atomicLong = redisson.getAtomicLong("myAtomicLongExample");
        atomicLong.set(5);
        atomicLong.incrementAndGet();

        // Topic

        RTopic<String> subscribeTopic = redisson.getTopic("TopicObjectExample");
        subscribeTopic.addListener(
                (channel, customMessage)
                        -> {
                    System.out.println("Nơi 1 nhận tin nhắn" + customMessage);
                });

        RTopic<String> subscribeTopic2 = redisson.getTopic("TopicObjectExample");
        subscribeTopic2.addListener(
                (channel, customMessage)
                        -> {
                    System.out.println("Nơi 2 nhận tin nhắn" + customMessage);
                });

        RTopic<String> publishTopic = redisson.getTopic("TopicObjectExample");
        publishTopic.publishAsync("Thông báo").handle((aLong, throwable) -> {
            System.out.println("gửi thành công");
            return true;
        });

    }
}