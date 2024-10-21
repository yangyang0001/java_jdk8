package com.deepblue.mine_01_java_jdk8.example_013_intstream;

import java.util.stream.IntStream;

/**
 * 不同类型的 Stream, IntStream LongStream 纯 Stream
 */
public class Main {

    public static void main(String[] args) {

        IntStream stream = IntStream.of(10, 2, 30, 15, 100, 25);
        stream.forEach(System.out::println);

        System.out.println("----------------------------------------------------------------");

        IntStream stream1 = IntStream.of(10, 22, 14, 16, 100, 22);
        stream1.sorted().forEach(System.out::println);

        System.out.println("----------------------------------------------------------------");

        IntStream.range(1, 8).forEach(System.out::println);

        System.out.println("----------------------------------------------------------------");

        IntStream.rangeClosed(1, 8).forEach(System.out::println);

        System.out.println("----------------------------------------------------------------");



    }
}
