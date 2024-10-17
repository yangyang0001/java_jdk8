package com.deepblue.java_jdk8.example_001_list;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 */
public class Main {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 10, 2, 5, 10);

        list.sort(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        list.stream().forEach(item -> {
            System.out.println("item = " + item);
        });




    }
}
