package com.deepblue.java_jdk8.example_011_default_method;

/**
 * 对于 default method 而言, 实现的优先级 extends > implements
 */
public class Main {

    public static void main(String[] args) {

        MineObject object = new MineObject();

        object.sayHello();

    }
}
