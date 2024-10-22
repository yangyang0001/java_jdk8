package com.deepblue.mine_02_deepsource.example_004_collectors_groupingBy_partitioningBy;

import java.util.*;
import java.util.stream.Collectors;

public class MineGrouping {

    public static void main(String[] args) {

        Student student1 = new Student(1L, "zhangsan", "111", 1, 20, 1L, 99);
        Student student2 = new Student(2L, "wangfang", "222", 0, 25, 2L, 60);
        Student student3 = new Student(3L, "wangwu", "333", 1, 20, 1L, 82);
        Student student4 = new Student(4L, "xiaoying", "444", 0, 35, 2L, 88);
        Student student5 = new Student(5L, "maosan", "555", 1, 25, 2L, 55);
        Student student6 = new Student(6L, "shengren", "666", 1, 22, 2L, 100);

        List<Student> students = Arrays.asList(student1, student2, student3, student4, student5, student6);

        /**
         * 1.根据学生的 classId 分组!
         */
        Map<Long, List<Student>> collect = students.stream().collect(Collectors.groupingBy(Student::getClassId));
        System.out.println(collect);

        System.out.println("-----------------------------------------------------------------------------------");

        /**
         * 2.根据学生的年龄分组 取出每个分组中 成绩最低的 学生来!
         */
        Map<Integer, Student> collect1 = students.stream().collect(Collectors.groupingBy(Student::getAge,
                Collectors.collectingAndThen(Collectors.minBy(Comparator.comparingInt(Student::getScore)), Optional<Student>::get)));
        System.out.println(collect1);


    }
}
