package com.deepblue.java_jdk8.example_012_stream_definition;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 */
public class Main {

    public static void main(String[] args) {

        /**
         * stream 定义, stream 是集合元素的管道!
         */
        List<String> list = Arrays.asList("zhangsan", "lisi", "wangwu");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * stream 的获取方式!
         */
        Stream<String> stream1 = Stream.of("maosan", "gousi", "niuqi");
        stream1.forEach(System.out::println);


    }

}
