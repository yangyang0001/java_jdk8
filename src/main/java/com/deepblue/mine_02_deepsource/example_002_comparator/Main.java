package com.deepblue.mine_02_deepsource.example_002_comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 */
public class Main {

    public static void main(String[] args){

        List<String> list = Arrays.asList("nihao111", "hello22", "world3", "welcome444");

        /**
         * 1.按照字符的先后顺序进行排序
         */
        List<String> collect = list.stream().sorted(String::compareTo).collect(Collectors.toList());
        System.out.println(collect);

        /**
         * 1.按照字符的先后顺序进行排序 使用 Collections.sort(list, ~) 方法!
         */
        Collections.sort(list, String::compareTo);
        System.out.println(list);

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * 2.lambda表达式的方式实现按长度来比较
         */
        List<String> collect1 = list.stream().sorted((item1, item2) -> item1.length() - item2.length()).collect(Collectors.toList());
        System.out.println(collect1);

        /**
         * 2.lambda表达式的方式实现按长度来比较 使用 Collections.sort(list, ~) 方法!
         */
        Collections.sort(list, (item1, item2) -> item1.length() - item2.length());
        System.out.println(list);

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * 3.使用 Comparator 接口来实现按长度 由长到短的 排序这里注意类型的推断
         */
        List<String> collect2 = list.stream().sorted(Comparator.comparingInt(String::length).reversed()).collect(Collectors.toList());
        System.out.println(collect2);

        /**
         * 3.使用 Comparator 接口来实现按长度 由长到短的 排序这里注意类型的推断
         */
        Collections.sort(list, Comparator.comparingInt(String::length).reversed());
        System.out.println(list);



    }
}
