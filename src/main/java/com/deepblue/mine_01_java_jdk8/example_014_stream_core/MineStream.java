package com.deepblue.mine_01_java_jdk8.example_014_stream_core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream 最核心的东西!
 */
public class MineStream {

    public static void main(String[] args) {

        Person person1 = new Person(1L, "zhangsan", "", 10, 1);
        Person person2 = new Person(2L, "xiaohong", "", 20, 0);
        Person person3 = new Person(3L, "xiaoling", "", 30, 0);
        Person person4 = new Person(4L, "lisi", "", 15, 1);
        Person person5 = new Person(5L, "wangwu", "", 25, 1);

        List<Person> persons = Arrays.asList(person1, person2, person3, person4, person5);
        String joining = persons.stream().map(item -> item.getName()).collect(Collectors.joining("_"));
        System.out.println("joining = " + joining);
        System.out.println("---------------------------------------------------------------------------");

        Stream<String> stream = Stream.of("zhangsan", "lisi", "wangwu");
        ArrayList<String> collect = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        collect.stream().forEach(System.out::println);
        System.out.println("---------------------------------------------------------------------------");

        // 从实际角度出发, 不用自己实现 collect 方法! 因为有现成的!
        Stream<String> stream1 = Stream.of("maosan", "gousi", "niuqi");
        stream1.collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("---------------------------------------------------------------------------");

        // Stream 转成 各种集合的 API 演示
        Stream<String> stream2 = Stream.of("zhangsan", "lisi", "wangwu", "zhangsan", "lisi");
        List<String> mineList = stream2.collect(Collectors.toList());
        mineList.stream().forEach(System.out::println);
        System.out.println("---------------------------------------------------------------------------");

        Stream<String> stream3 = Stream.of("zhangsan", "lisi", "wangwu", "zhangsan", "lisi");
        Set<String> mineSet = stream3.collect(Collectors.toSet());
        mineSet.stream().forEach(System.out::println);
        System.out.println("---------------------------------------------------------------------------");

        Stream<String> stream4 = Stream.of("zhangsan", "lisi", "wangwu", "zhangsan", "lisi");
        String mineString = stream4.collect(Collectors.joining("")).toString();
        System.out.println(mineString);
        System.out.println("---------------------------------------------------------------------------");




    }
}
