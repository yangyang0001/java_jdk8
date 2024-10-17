package com.deepblue.java_jdk8.example_008_optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 */
public class Main {

    public static void main(String[] args) {

        Optional<String> optional = Optional.of("zhangsan");
        System.out.println(optional.get());
        System.out.println(optional.isPresent());
        System.out.println(optional.orElse("lisi"));
        System.out.println(optional.orElseGet(() -> "lisi"));

        System.out.println("------------------------------------------------------------------------------------");


        List<Person> sourceList = new ArrayList<>();
        Person person1 = new Person(1L, "zhangsan", "111", 10);
        Person person2 = new Person(2L, "lisi", "222", 20);
        Person person3 = new Person(3L, "wangwu", "333", 30);
        Person person4 = new Person(4L, "zhaoliu", "444", 40);
        sourceList.add(person1);
        sourceList.add(person2);
        sourceList.add(person3);
        sourceList.add(person4);

        Optional<List<Person>> optional1 = Optional.of(sourceList);
        optional1.get().stream().forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------------------");

        System.out.println("optional1 is empty :" + optional1.get().isEmpty());


        System.out.println("------------------------------------------------------------------------------------");

        List<Person> collect = optional1.get().stream().filter(item -> item.getAge() > 10).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------------------");

        List<String> collect1 = sourceList.stream().map(item -> item.getName()).collect(Collectors.toList());
        collect1.stream().forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------------------");
    }
}
