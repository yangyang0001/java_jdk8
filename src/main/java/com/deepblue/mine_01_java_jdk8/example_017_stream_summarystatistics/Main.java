package com.deepblue.mine_01_java_jdk8.example_017_stream_summarystatistics;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 聚合函数 summaryStatistics
 */
public class Main {

    public static void main(String[] args) {

        Stream<Integer> stream = Stream.iterate(1, item -> item * 2).limit(5);
        stream.forEach(System.out::println);

        Stream<Integer> stream1 = Stream.iterate(1, item -> item * 2).limit(5);
        IntSummaryStatistics statistics = stream1.collect(Collectors.summarizingInt(item -> item));
        long count = statistics.getCount();
        int max = statistics.getMax();
        int min = statistics.getMin();
        long sum = statistics.getSum();
        double avg = statistics.getAverage();

        System.out.println("count = " + count + ", max = " + max + ", min = " + min + ", sum = " + sum + ", avg" + avg);


    }
}
