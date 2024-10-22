package com.deepblue.mine_02_deepsource.example_004_collectors_groupingBy_partitioningBy;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 */
public class MinePartitioning {

    public static void main(String[] args){

        Student student1 = new Student(1L, "zhangsan", "111", 1, 20, 1L, 99);
        Student student2 = new Student(2L, "wangfang", "222", 0, 25, 2L, 60);
        Student student3 = new Student(3L, "wangwu", "333", 1, 20, 1L, 82);
        Student student4 = new Student(4L, "xiaoying", "444", 0, 35, 2L, 88);
        Student student5 = new Student(5L, "maosan", "555", 1, 25, 2L, 55);
        Student student6 = new Student(6L, "shengren", "666", 1, 22, 2L, 100);

        List<Student> students = Arrays.asList(student1, student2, student3, student4, student5, student6);

        /**
         * 1.根据年龄分区(只能分两个区, 不大于25岁 和 25岁以上的), 然后查询到每个分组中的score 最大的 student
         */
        Map<Boolean, Student> collect = students.stream().collect(Collectors.partitioningBy(item -> item.getAge() > 25, Collectors.collectingAndThen(
                Collectors.maxBy(Comparator.comparingInt(Student::getScore)), Optional::get)));
        System.out.println(collect);

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * 2.根据年龄分区(只能分两个区, 不大于25岁 和 25岁以上的), 然后查询对每个分区中的学生的分值求和
         */
        Map<Boolean, Integer> collect1 = students.stream().collect(Collectors.partitioningBy(item -> item.getAge() > 25, Collectors.summingInt(Student::getScore)));
        System.out.println(collect1);

    }

}
