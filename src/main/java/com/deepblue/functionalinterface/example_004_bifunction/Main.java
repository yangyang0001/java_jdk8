package com.deepblue.functionalinterface.example_004_bifunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * BiFunction<参数1类型, 参数2类型, 返回值类型>
 */
public class Main {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> function = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer param1, Integer param2) {
                return param1 > param2 ? param1 : param2;
            }
        };
        Integer result = function.apply(10, 100);
        System.out.println("result = " + result);

        System.out.println("--------------------------------------------------------------------------------");
        
        BiFunction<Integer, List<Student>, List<Student>> function1 = (param, list) -> {
            List<Student> collect = list.stream().filter(item -> item.getAge() > param).collect(Collectors.toList());
            if(collect.isEmpty()) {
                return new ArrayList<>();
            } else {
                return collect;
            }
        };
        
        Student student1 = new Student(1L, "zhangsan", "111", 1, 20, 1L);
        Student student2 = new Student(2L, "wangfang", "222", 0, 25, 2L);
        Student student3 = new Student(3L, "wangwu", "333", 1, 20, 1L);
        Student student4 = new Student(4L, "xiaoying", "444", 0, 35, 2L);
        Student student5 = new Student(5L, "maosan", "555", 1, 25, 2L);

        Integer param = 30;
        List<Student> list = Arrays.asList(student1, student2, student3, student4, student5);
        List<Student> students = function1.apply(param, list);
        System.out.println("students.size = " + students.size());
        students.parallelStream().forEach(System.out::println);


    }
}
