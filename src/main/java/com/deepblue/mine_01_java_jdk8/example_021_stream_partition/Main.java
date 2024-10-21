package com.deepblue.mine_01_java_jdk8.example_021_stream_partition;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 */
public class Main {

    public static void main(String[] args) {

        Student student1 = new Student(1L, "zhangsan", "111", 1, 20, 1L, 90);
        Student student2 = new Student(2L, "wangfang", "222", 0, 25, 2L, 60);
        Student student3 = new Student(3L, "wangwu", "333", 1, 20, 1L, 88);
        Student student4 = new Student(4L, "xiaoying", "444", 0, 35, 2L, 88);
        Student student5 = new Student(5L, "maosan", "555", 1, 25, 2L, 55);

        List<Student> list = Arrays.asList(student1, student2, student3, student4, student5);

        Map<Boolean, List<Student>> collect = list.parallelStream().collect(Collectors.partitioningBy(item -> item.getAge() > 20));

        collect.forEach((flag, students) -> {
            System.out.println("flag = " + flag + ", students.size = " + students.size());
            students.forEach(System.out::println);
            System.out.println("--------------------------------------------------------------------");
        });

        System.out.println("----------------------------------------------------------------------------------------------------");


    }
}
