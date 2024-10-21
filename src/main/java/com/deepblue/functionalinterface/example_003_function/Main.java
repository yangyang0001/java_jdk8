package com.deepblue.functionalinterface.example_003_function;

import java.util.function.Function;

/**
 * Function<参数类型, 返回值类型>
 */
public class Main {

    public static void main(String[] args) {

        /**
         * Function 针对单个参数 进行操作, 一个返回值!  实现方法为 R apply(T param)
         */
        Function<Integer, Integer> function = item -> item + 2;
        Integer result = function.apply(10);
        System.out.println("result = " + result);

        System.out.println("--------------------------------------------------------------------------------");

        Function<Integer, Integer> function1 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer param) {
                return param * 2;
            }
        };
        Integer result1 = function1.apply(10);
        System.out.println("result1 = " + result1);

    }



}
