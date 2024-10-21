package com.deepblue.mine_00_functionalinterface.example_001_consumer;

import java.util.function.Consumer;

/**
 * Consumer<参数类型> 对输入的参数直接操作, 无返回值!
 */
public class Main {

    public static void main(String[] args) {

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String param) {
                System.out.println(param);
            }
        };
        consumer.accept("zhangsan");

        System.out.println("--------------------------------------------------------------------------------");

        Consumer<String> consumer1 = item -> System.out.println(item);
        consumer1.accept("hello consumer");

    }

}
