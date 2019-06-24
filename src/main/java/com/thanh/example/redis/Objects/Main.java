package com.thanh.example.redis.Objects;

import com.thanh.example.redis.ConnectRedis;
import com.thanh.example.redis.entity.Test;
import org.redisson.api.*;
import org.redisson.api.listener.MessageListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException {
        RedissonClient redisson = ConnectRedis.connect();

        List<Integer> listRoomID = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listRoomID.add(i);
        }


        //With object
        RBucket<Test> bucket = redisson.getBucket("ObjectBucketExample");
        bucket.set(new Test(122), 50, TimeUnit.SECONDS);

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

        RTopic subscribeTopic = redisson.getTopic("TopicObjectExample");

        subscribeTopic.addListener(Object.class, new MessageListener() {
            @Override
            public void onMessage(CharSequence channel, Object msg) {
                System.out.println("channel " + channel.toString());
                System.out.println("Nơi 1 nhận tin nhắn" + msg);
            }
        });


        RTopic publishTopic = redisson.getTopic("TopicObjectExample");
        publishTopic.publishAsync("Thông báo").handle((aLong, throwable) -> {
            System.out.println("gửi thành công");
            return true;
        });

    }
}
