package com.deepblue.mine_01_java_jdk8.example_011_default_method;

public interface MineInterface {

    default void sayHello() {
        System.out.println("MineInterface default method sayHello invoke!");
    }


}