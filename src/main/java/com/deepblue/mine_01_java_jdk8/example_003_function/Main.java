package com.deepblue.mine_01_java_jdk8.example_003_function;

/**
 *
 */
public class Main {

    public static void main(String[] args) {

        /**
        List<Integer> list = Arrays.asList(1, 11, 2, 4, 55, 22);
        Collections.sort(list);

        list.stream().forEach(item -> System.out.println(item));
        */

        /**
         * 使用自己的 Function
         */
        MineFunction mine = new MineFunction();

        /**
         * 入参, 输入表达式(value) -> 输出表达式(2 * value)!
         */
        System.out.println(mine.compute(10, value -> value + 2));
        System.out.println(mine.compute(10, value -> value - 2));
        System.out.println(mine.compute(10, value -> value * 2));

        System.out.println(mine.convert(10, value -> "Hello " + value));


    }

}
