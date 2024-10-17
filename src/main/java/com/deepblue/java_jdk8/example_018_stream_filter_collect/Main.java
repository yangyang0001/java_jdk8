package com.deepblue.java_jdk8.example_018_stream_filter_collect;

import org.bouncycastle.util.Strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 */
public class Main {

    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(1, 4, 6, 8, 44, 66, 8, 22);
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // 只有 list1 包含的元素
        Stream<List<Integer>> stream = Stream.of(list1, list2);
        List<Integer> collect = stream.flatMap(item -> item.stream()).filter(item -> list1.contains(item) && !list2.contains(item)).collect(Collectors.toList());
        String result = collect.stream().map(item -> String.valueOf(item)).collect(Collectors.joining(" ")).toString();
        System.out.println("result = " + result);
        System.out.println("------------------------------------------------------------------------------------------");

        // 只有 list2 包含的元素
        Stream<List<Integer>> stream1 = Stream.of(list1, list2);
        List<Integer> collect1 = stream1.flatMap(item -> item.stream()).filter(item -> !list1.contains(item) && list2.contains(item)).collect(Collectors.toList());
        String result1 = collect1.stream().map(item -> String.valueOf(item)).collect(Collectors.joining(" ")).toString();
        System.out.println("result1 = " + result1);

        System.out.println("------------------------------------------------------------------------------------------");

        // 将 list1, list2 中 不同时包含的元素 进行排序
        Stream<List<Integer>> stream2 = Stream.of(list1, list2);
        List<Integer> collect2 = stream2.flatMap(item -> item.stream()).filter(item -> !(list1.contains(item) && list2.contains(item))).sorted().collect(Collectors.toList());
        String result2 = collect2.stream().map(item -> String.valueOf(item)).collect(Collectors.joining(" ")).toString();
        System.out.println("result2 = " + result2);

        //


    }
}
