package com.deepblue.java_jdk8.example_010_consumer_biconsumer;

import java.util.function.Consumer;

/**
 * consumer 只接收参数, 没有返回值!
 */
public class MineConsumer {

    public static void main(String[] args) {

        Consumer<String> consumer0 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        consumer0.accept("zhangsan");

        Consumer<Person> consumer1 = System.out::println;
        consumer1.accept(new Person(1L, "zhangsan", "111", 10, 1));

    }
}
