package com.deepblue.mine_01_java_jdk8.example_007_binaryoperator;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 *
 */
public class MineBinaryOperator {

    public Integer compute(int value1, int value2, BinaryOperator<Integer> operator) {
        return operator.apply(value1, value2);
    }

    public Integer max(int value1, int value2, Comparator<Integer> comparator) {
        int compare = comparator.compare(value1, value2);
        int result = compare > 0 ? value1 : value2;
        return result;
    }

    public Integer maxBy(int value1, int value2, Comparator<Integer> comparator) {
        return BinaryOperator.maxBy(comparator).apply(value1, value2);
    }

    public Integer minBy(int value1, int value2, Comparator<Integer> comparator) {
        return BinaryOperator.minBy(comparator).apply(value1, value2);
    }

}
