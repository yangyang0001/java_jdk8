package com.deepblue.java_jdk8.example_003_function;

import java.util.function.Function;

/**
 *
 */
public class MineFunction {

    public int compute(int num, Function<Integer, Integer> function) {
        return function.apply(num);
    }

    public String convert(int num, Function<Integer, String> function) {
        return function.apply(num);
    }

}
