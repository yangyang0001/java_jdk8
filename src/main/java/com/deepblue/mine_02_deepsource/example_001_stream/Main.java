package com.deepblue.mine_02_deepsource.example_001_stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 */
public class Main {

    public static void main(String[] args) {

        Student student1 = new Student(1L, "zhangsan", "111", 1, 20, 1L, 99);
        Student student2 = new Student(2L, "wangfang", "222", 0, 25, 2L, 60);
        Student student3 = new Student(3L, "wangwu", "333", 1, 20, 1L, 82);
        Student student4 = new Student(4L, "xiaoying", "444", 0, 35, 2L, 88);
        Student student5 = new Student(5L, "maosan", "555", 1, 25, 2L, 55);
        Student student6 = new Student(6L, "shengren", "666", 1, 22, 2L, 100);

        List<Student> students = Arrays.asList(student1, student2, student3, student4, student5, student6);

        /**
         * 1.将集合转换成流,然后再转换成集合
         */
        List<Student> collect = students.stream().collect(Collectors.toList());
        collect.stream().forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * 2.通过流的方式拿到集合的个数
         */
        long count = students.stream().count();
        System.out.println("count = " +  count);

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * 3.获取到集合中学生成绩最低的学生
         */
        Optional<Student> optional = students.stream().sorted(Comparator.comparingInt(Student::getScore)).findFirst();
        Student min = optional.isPresent() ? optional.get() : null;
        System.out.println("min = " + min);

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * 3.用 collect 方法实现 获取到集合中学生成绩最低的学生, 嵌套不容易理解, 这里仅供参考!
         */
        min = students.stream().collect(Collectors.minBy(Comparator.comparingInt(Student::getScore))).get();
        System.out.println("min = " + min);

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * 4.获取到集合中学生成绩最高的学生, 可以用原声的 API, 可以自己重写 sorted 方法!
         */
        Optional<Student> optional1 = students.stream().sorted(Comparator.comparingInt(Student::getScore).reversed()).findFirst();
        Student max = optional1.isPresent() ? optional1.get() : null;
        System.out.println("max = " + max);

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * 4.用 collect 方法实现 获取到集合中学生成绩最高的学生, 嵌套不容易理解, 这里仅供参考!
         */
        max = students.stream().collect(Collectors.maxBy(Comparator.comparingInt(Student::getScore))).get();
        System.out.println("max = " + max);

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * 5.获取学生的 成绩平均值!
         */
        Double avgScore = students.stream().collect(Collectors.averagingDouble(item -> item.getScore()));
        System.out.println("avgScore = " + avgScore);

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * 6.获取成绩的总和
         */
        long sum = students.stream().collect(Collectors.summarizingInt(Student::getScore)).getSum();
        System.out.println("sumScore = " + sum);

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * 6.获取成绩的总和
         */
        Integer sum1 = students.stream().collect(Collectors.summingInt(Student::getScore));
        System.out.println("sumScore = " + sum1);

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * 7.将所有的student的姓名进行拼接
         */
        String names = students.stream().map(item -> item.getName()).collect(Collectors.joining("_")).toString();
        System.out.println("names = " + names);

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * 8.根据 classId 分组
         */
        Map<Long, List<Student>> collect1 = students.stream().collect(Collectors.groupingBy(Student::getClassId));
        collect1.forEach((classId, list) -> {
            list.stream().forEach(item -> {
                System.out.println("classId = " + classId + ", item = " + item);
            });
            System.out.println();
        });

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * 8.首先根据 classId 分组, 再根据 gender 分组
         */
        Map<Long, Map<Integer, List<Student>>> collect2 = students.stream().collect(Collectors.groupingBy(Student::getClassId, Collectors.groupingBy(Student::getGender)));
        collect2.forEach((classId, genders) -> {
            genders.forEach((gender, list) -> {
                list.forEach(item -> {
                    System.out.println("classId = " + classId + ", gender = " + gender + ", item = " + item);
                });
                System.out.println();
            });
            System.out.println("\n");
        });

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * 9.根据成绩分区, 大于80 和 小于等于80 两个区
         */
        Map<Boolean, List<Student>> collect3 = students.stream().collect(Collectors.partitioningBy(item -> item.getScore() > 80));
        collect3.forEach((flag, list) -> {
            list.stream().forEach(item -> {
                System.out.println("flag = " + flag + ", item = " + item);
            });
        });

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * 10.分区后进行结果求和
         */
        Map<Boolean, Long> collect4 = students.stream().collect(Collectors.groupingBy(item -> item.getScore() > 80, Collectors.summingLong(Student::getScore)));
        collect4.forEach((flag, groupsum) -> {
            System.out.println("flag = " + flag + ", groupsum = " + groupsum);
        });

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * 11.按照下面的要求分区后, 再进行求和
         * 不大 80
         * 大于 80
         *      不大 90
         *      大于 90
         */

        Map<Boolean, Map<Boolean, Integer>> collect5 = students.stream().collect(Collectors.partitioningBy(item -> item.getScore() > 80, Collectors.groupingBy(item -> item.getScore() > 90, Collectors.summingInt(Student::getScore))));
        collect5.forEach((flag1, map) -> {
            map.forEach((flag2, item) -> {
                System.out.println("flag1 = " + flag1 + ", flag2 = " + flag2 + ", item = " + item);
            });
        });

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * 12.先根据 classId 进行分组, 然后 取每个组中成绩最低的 学生
         */
        Map<Long, Optional<Student>> collect6 = students.stream()
                .collect(Collectors.groupingBy(Student::getClassId, Collectors.minBy(Comparator.comparingInt(Student::getScore))));
        collect6.forEach((classId, optional2) -> {
            System.out.println("classId = " + classId + ", student = " + optional2.get());
        });

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * 12.使用 collectingAndThen 先根据 classId 进行分组, 然后 取每个组中成绩最低的 学生
         */
        Map<Long, Student> collect7 = students.stream()
                .collect(Collectors.groupingBy(Student::getClassId, Collectors.collectingAndThen(Collectors.minBy(Comparator.comparingInt(Student::getScore)), Optional<Student>::get)));
        collect7.forEach((classId, item) -> {
            System.out.println("classId = " + classId + ", item = " + item);
        });
        
    }
}
