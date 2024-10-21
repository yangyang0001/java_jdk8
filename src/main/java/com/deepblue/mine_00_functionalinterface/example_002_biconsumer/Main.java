package com.deepblue.mine_00_functionalinterface.example_002_biconsumer;

import java.util.function.BiConsumer;

/**
 * BiConsumer<参数类型1, 参数类型2> 无返回值!
 */
public class Main {

    public static void main(String[] args) {

        BiConsumer<String, String> consumer = new BiConsumer<String, String>() {
            @Override
            public void accept(String param1, String param2) {
                System.out.println("param1 = " + param1 + ", param2 = " + param2);
            }
        };
        consumer.accept("zhangsan", "lisi");

        System.out.println("------------------------------------------------------------------------------");

        BiConsumer consumer1 = (param1, param2) -> System.out.println("param1 = " + param1 + ", param2 = " + param2);
        consumer1.accept("zhangsan", "wangwu");

    }
}
