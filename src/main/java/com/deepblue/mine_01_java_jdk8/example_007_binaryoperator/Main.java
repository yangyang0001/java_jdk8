package com.deepblue.mine_01_java_jdk8.example_007_binaryoperator;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 *
 */
public class Main {

    public static void main(String[] args) {

        /**
        BinaryOperator<Integer> operatorPlus = (value1, value2) -> {
            return value1 + value2;
        };

        BiFunction<Integer, Integer, Integer> biFunction = (value1, value2) -> {
            return value1 + value2;
        };

        System.out.println(operatorPlus.apply(20, 30));
        System.out.println(biFunction.apply(10, 30));

        MineBinaryOperator operator = new MineBinaryOperator();
        System.out.println(operator.max(10, 20, (value1, value2) -> value1 - value2));
        */

        Integer max = BinaryOperator.maxBy(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }).apply(10, 200);

        System.out.println("max = " + max);

        MineBinaryOperator mine = new MineBinaryOperator();
        System.out.println("max = " + mine.maxBy(50, 500, (value1, value2) -> value1 - value2));
        System.out.println("min = " + mine.minBy(60, 600, (value1, value2) -> value1 - value2));


    }

}
