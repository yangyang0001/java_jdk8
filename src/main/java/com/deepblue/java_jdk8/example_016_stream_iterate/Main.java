package com.deepblue.java_jdk8.example_016_stream_iterate;

import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

/**
 * Stream 迭代函数 iterate(起点, 应用于起点元素以生成新元素的函数)
 */
public class Main {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("zhangsan", "lisi", "wangwu");
        boolean firstFlag = stream.findFirst().isPresent();
        System.out.println("firstFlag = " + firstFlag);
        System.out.println("------------------------------------------------------------------------------------------");


        Stream.iterate(1, item -> item * 2).limit(6).forEach(System.out::println);
        System.out.println("------------------------------------------------------------------------------------------");


        Stream.iterate(1, item -> item * 2).limit(6).skip(2).forEach(System.out::println);
        System.out.println("------------------------------------------------------------------------------------------");


        int sum = Stream.iterate(1, item -> item * 2).limit(6).skip(2).mapToInt(item -> item).sum();
        System.out.println(sum);
        System.out.println("------------------------------------------------------------------------------------------");


    }
}
