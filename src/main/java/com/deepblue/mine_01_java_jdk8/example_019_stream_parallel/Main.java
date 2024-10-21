package com.deepblue.mine_01_java_jdk8.example_019_stream_parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 经过验证 parallelStream() 比 stream() 遍历快!
 */
public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < 5000; i++) {
            list.add(UUID.randomUUID().toString());
        }

        long start = System.currentTimeMillis();
        list.stream().forEach(item -> System.out.print(""));
        long end = System.currentTimeMillis();
        System.out.println("stream cost time = " + (end - start) + "ms");

        long start1 = System.currentTimeMillis();
        list.parallelStream().forEach(System.out::println);
        long end1 = System.currentTimeMillis();
        System.out.println("parallel stream cost time = " + (end1 - start1) + "ms");

    }


}
