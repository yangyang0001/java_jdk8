package com.deepblue.java_jdk8.example_015_stream_map_flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 */
public class Main {

    public static void main(String[] args) {

        /**
         * stream map 转换成大写!
         */
        Stream<String> stream = Stream.of("usa", "china", "japan");
//        stream.map(String::toUpperCase).forEach(System.out::println);
//        stream.map(item -> Strings.toUpperCase(item)).forEach(System.out::println);
        stream.map(item -> item.toUpperCase()).forEach(System.out::println);
        System.out.println("----------------------------------------------------------------------");

        /**
         *  IntStream map 的使用
         */
        IntStream stream1 = IntStream.of(1, 3, 5);
        stream1.map(item -> (int) Math.pow(item, 2)).forEach(System.out::println);
        System.out.println("----------------------------------------------------------------------");

        /**
         * Stream flatMap 的使用
         */
        List<Integer> list1 = Arrays.asList(1, 3);
        List<Integer> list2 = Arrays.asList(3, 5);
        List<Integer> list3 = Arrays.asList(5, 7);

        Stream<List<Integer>> stream2 = Stream.of(list1, list2, list3);
        stream2.flatMap(item -> item.stream()).collect(Collectors.toSet()).forEach(System.out::println);
        System.out.println("----------------------------------------------------------------------");


        List<String> strings1 = Arrays.asList("zhangsan", "lisi", "wangwu", "maosan", "gousi", "niuqi");
        List<String> strings2 = Arrays.asList("zhangsan", "xiaoming", "xiaohong", "xiaoling", "gousi", "niuqi");
        Set<String> set = Arrays.asList(strings1, strings2).stream().flatMap(item -> item.stream())
                .filter(item -> !(strings1.contains(item) && strings2.contains(item)))
                .collect(Collectors.toSet());
        set.stream().forEach(System.out::println);
        System.out.println("----------------------------------------------------------------------");


    }
}
