package com.thanh.example.redis.service.DistributedMapReduce;

import com.thanh.example.redis.ConnectRedis;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.api.mapreduce.RMapReduce;

import java.io.IOException;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) throws IOException {
        RedissonClient redisson = ConnectRedis.connect();
        RMap<String, String> map = redisson.getMap("wordsMap");
        map.put("line1", "Alice was beginning to get very tired");
        map.put("line2", "of sitting by her sister on the bank and");
        map.put("line3", "of having nothing to do once or twice she");
        map.put("line4", "had peeped into the book her sister was reading");
        map.put("line5", "but it had no pictures or conversations in it");
        map.put("line6", "and what is the use of a book");
        map.put("line7", "thought Alice without pictures or conversation");
        RMapReduce<String, String, String, Integer> mapReduce
                = map.<String, Integer>mapReduce()
                .mapper(new WordMapper())
                .reducer(new WordReducer());

        // count occurrences of words
        Map<String, Integer> mapToNumber = mapReduce.execute();
        System.out.println("ô");

    }

}
