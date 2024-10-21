package com.deepblue.mine_01_java_jdk8.example_004_bifunction;

import java.util.function.BiFunction;

/**
 *
 */
public class MineBiFunction {

    public int compute(int num1, int num2, BiFunction<Integer, Integer, Integer> function) {
        return function.apply(num1, num2);
    }

    public String convert(int num1, int num2, BiFunction<Integer, Integer, String> function) {
        return function.apply(num1, num2);
    }

}
