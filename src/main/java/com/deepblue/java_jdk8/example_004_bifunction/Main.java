package com.deepblue.java_jdk8.example_004_bifunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 *
 */
public class Main {

    public static void main(String[] args) {

        MineBiFunction function = new MineBiFunction();

        System.out.println(function.compute(20, 10, (num1, num2) -> num1 + num2));
        System.out.println(function.compute(20, 10, (num1, num2) -> num1 - num2));
        System.out.println(function.compute(20, 10, (num1, num2) -> num1 * num2));

        System.out.println(function.convert(20, 10, (num1, num2) -> num1 + "---" + num2));


        BiFunction<Integer, List<Person>, List<Person>> biFunction = (base, sourceList) -> {
            return sourceList.stream().filter(item -> item.getAge() > base).collect(Collectors.toList());
        };

        List<Person> sourceList = new ArrayList<>();
        Person person1 = new Person(1L, "zhangsan", "111", 10);
        Person person2 = new Person(2L, "zhangsan", "222", 20);
        Person person3 = new Person(3L, "zhangsan", "333", 30);
        Person person4 = new Person(4L, "zhangsan", "444", 40);
        sourceList.add(person1);
        sourceList.add(person2);
        sourceList.add(person3);
        sourceList.add(person4);

        List<Person> targetList = biFunction.apply(20, sourceList);
        targetList.stream().forEach(System.out::println);

    }
}
