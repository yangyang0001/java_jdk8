package com.deepblue.mine_01_java_jdk8.example_020_stream_collect_group;

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


        // 根据 classId 进行分组!
        List<Student> list = Arrays.asList(student1, student2, student3, student4, student5);
        Map<Long, List<Student>> collect = list.stream().collect(Collectors.groupingBy(Student::getClassId));
        for(Map.Entry<Long, List<Student>> entry : collect.entrySet()) {
            System.out.println("classId = " + entry.getKey());
            entry.getValue().stream().forEach(System.out::println);
            System.out.println("--------------------------------------------------------------------------");
        }

        System.out.println("----------------------------------------------------------------------------------------------------");

        collect.forEach((classId, students) -> {
            System.out.println("classId = " + classId + ", students.size = " + students.size());
            students.stream().forEach(System.out::println);
            System.out.println("--------------------------------------------------------------------------");
        });

        System.out.println("----------------------------------------------------------------------------------------------------");




    }
}
