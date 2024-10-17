package com.deepblue.java_jdk8.example_002_interface;

/**
 *
 */
public class Main {

    public static void main(String[] args) {

        // 接口实例化
        MineInterface mine = () -> {
            System.out.println("mine interface instance invoke!");
        };

        // 实例化执行!
        mine.mine();

        // 线程直接实例化
        new Thread(() -> {
            System.out.println("thread instance invoke!");
        }).start();

    }
}
