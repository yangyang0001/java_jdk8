package com.deepblue.mine_00_functionalinterface.example_009_stream;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 */
public class Main {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(14, 1, 22, 3, 5, 7, 18, 10);

        /**
         * 1.按照 stream 的方式 打印 list
         */
        list.parallelStream().forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * 2.查询出 list 中的偶数!
         */
        list.parallelStream().filter(item -> item % 2 == 0).forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * 3.集合求和
         */
        int sum = list.parallelStream().mapToInt(item -> item).sum();
        System.out.println("sum = " + sum);

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * 4.将集合中的元素 拼接成 字符串
         */
        List<String> list1 = Arrays.asList("welcome", "to", "jdk8");
        String collect = list1.parallelStream().collect(Collectors.joining(" "));
        System.out.println(collect);

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * 5.将集合中的元素 转换成 大写
         */
        list1.parallelStream().map(String::toUpperCase).forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * 6.将 list2 list3 中的 每个元素进行 平方 然后输出
         */
        List<Integer> list2 = Arrays.asList(1, 3, 5, 7);
        List<Integer> list3 = Arrays.asList(2, 3, 5, 8);

        List<List<Integer>> lists = Arrays.asList(list2, list3);
        lists.parallelStream().flatMap(item -> item.parallelStream()).map(item -> item * item).forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * 7.对集合进行sum,avg,min,max操作
         */
        IntSummaryStatistics statistics = list.parallelStream().collect(Collectors.summarizingInt(item -> item));
        System.out.println("sum = " + statistics.getSum());
        System.out.println("max = " + statistics.getMax());
        System.out.println("min = " + statistics.getMin());
        System.out.println("avg = " + statistics.getAverage());

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * 8.对 list2, list3 中的 交集去掉后 进行并集的操作
         */
        List<Integer> collect1 = Arrays.asList(list2, list3).parallelStream().flatMap(item -> item.stream())
                .filter(item -> !(list2.contains(item) && list3.contains(item))).collect(Collectors.toList());
        collect1.stream().sorted(Integer::compareTo).forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * 9.将 list4 中的 单词进行 去重后 组成一个 List
         */
        List<String> list4 = Arrays.asList("hello world", "hello java", "hello jdk8", "welcome to jdk8");
        String[] split = list4.stream().collect(Collectors.joining(" ")).split(" ");
        List<String> collect2 = Stream.of(split).distinct().collect(Collectors.toList());
        collect2.stream().forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------------------");


        Student student1 = new Student(1L, "zhangsan", "111", 1, 20, 1L, 90);
        Student student2 = new Student(2L, "wangfang", "222", 0, 25, 2L, 60);
        Student student3 = new Student(3L, "wangwu", "333", 1, 20, 1L, 88);
        Student student4 = new Student(4L, "xiaoying", "444", 0, 35, 2L, 88);
        Student student5 = new Student(5L, "maosan", "555", 1, 25, 2L, 55);

        /**
         * 10.将 学生 按照 classId 进行分组, 然后计算每个分组的 平均年龄!
         *
         * select classId, avg(age) from students group by classId;
         */
        List<Student> students = Arrays.asList(student1, student2, student3, student4, student5);
        Map<Long, Double> collect3 = students.stream().collect(Collectors.groupingBy(Student::getClassId, Collectors.averagingDouble(Student::getAge)));
        collect3.forEach((classId, avgAge) -> {
            System.out.println("classId = " + classId + ", avgAge = " + avgAge);
        });

        System.out.println("------------------------------------------------------------------------------------");

        /**
         * 11.按照 学生年龄段进行 分区, 分为 age <= 20 和 age > 20 两个区, 统计两个区的 学生个数!
         */
        Map<Boolean, Long> collect4 = students.stream().collect(Collectors.partitioningBy(item -> item.getAge() > 20, Collectors.counting()));
        collect4.forEach((flag, count) -> {
            System.out.println("flag = " + flag + ", count = " + count);
        });


    }
}
