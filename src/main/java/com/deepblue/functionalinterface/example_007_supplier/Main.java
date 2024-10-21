package com.deepblue.functionalinterface.example_007_supplier;


import java.util.function.Supplier;

/**
 * Supplier 没有输入, 只有输出!
 */
public class Main {

    public static void main(String[] args) {
        Supplier<Student> supplier = () -> new Student(100L, "zhangsan", "111", 1, 22, 1L);
        System.out.println(supplier.get());
    }

}