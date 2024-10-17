package com.deepblue.java_jdk8.example_009_method_reference;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

/**
 *
 */
public class Main {

    public static void main(String[] args) {

        Student student1 = new Student(1L, "zhangsan", "111", 18);
        Student student2 = new Student(2L, "lisi", "222", 10);
        Student student3 = new Student(3L, "wangwu", "333", 20);
        Student student4 = new Student(4L, "zhaoliu", "444", 15);


        List<Student> students = Arrays.asList(student1, student2, student3, student4);
        students.sort(Student::compareAge);
        students.stream().forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------");

        Supplier<Student> supplier = Student::new;
        System.out.println(supplier.get());

        System.out.println("------------------------------------------------------------------------");

        Student student5 = new Student(5L, "maosan", "555", 24);
        Student student6 = new Student(6L, "gousi", "666", 10);
        Student student7 = new Student(7L, "niuqi", "777", 11);
        Student student8 = new Student(8L, "yangba", "888", 25);

        List<Student> sources = Arrays.asList(student5, student6, student7, student8);
        sources.sort(Student::compare);
        sources.stream().forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------");

    }
}
