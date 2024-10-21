package com.deepblue.mine_01_java_jdk8.example_010_consumer_biconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 *
 */
public class MineBiConsumer {

    public static void main(String[] args) {

        List<Person> sources = new ArrayList<>();
        Person person = new Person(1L, "zhangsan", "111", 28, 1);

        BiConsumer<List<Person>, Person> consumer = (list, item) -> list.add(item);
        consumer.accept(sources, person);
        sources.stream().forEach(System.out::println);

    }

}
