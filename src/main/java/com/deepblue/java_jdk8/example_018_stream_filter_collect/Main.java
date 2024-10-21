package com.deepblue.java_jdk8.example_018_stream_filter_collect;

import org.bouncycastle.util.Strings;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
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

        System.out.println("------------------------------------------------------------------------------------------");

        // 将 list3 中的 单词去重 集合!
        List<String> list3 = Arrays.asList("hello world", "hello jdk8", "welcome to java jdk8", "hello java jdk8");
        String[] split1 = list3.parallelStream().collect(Collectors.joining(" ")).split(" ");
        Set<String> collect3 = Stream.of(split1).collect(Collectors.toSet());
        collect3.forEach(item -> System.out.print(item + " "));

        System.out.println("\n------------------------------------------------------------------------------------------");

        // 找到 list4 中的 第一个长度为4 的单词!
        List<String> list4 = Arrays.asList("zhangsan", "lisi", "xiao", "xiaowa", "xiaohe", "xiaoming");
        list4.stream().filter(item -> item.length() == 4).findFirst().ifPresent(System.out::println);

        System.out.println("--------------------------------------------------------------------------------------------");

        List<String> list5 = Arrays.asList("Hi", "Hello", "你好");
        List<String> list6 = Arrays.asList("zhangsan", "lisi", "wangwu");
        list5.stream().forEach(item1 -> {
            list6.stream().forEach(item2 -> {
                System.out.println(item1 + " " + item2);
            });
        });


    }
}
