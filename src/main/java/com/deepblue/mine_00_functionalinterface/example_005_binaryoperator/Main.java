package com.deepblue.mine_00_functionalinterface.example_005_binaryoperator;


import java.util.function.BinaryOperator;

/**
 * BiFunction<参数1类型, 参数2类型, 返回值类型> 的一种 针对 参数1 参数2 结果 都为同一种类型的 简化操作 BinaryOperator<两个参数和返回值为同一种类型>
 */
public class Main {

    public static void main(String[] args) {

        BinaryOperator<Integer> operator = (param1, param2) -> param1 + param2;
        Integer result = operator.apply(10, 100);
        System.out.println("result = " + result);

        BinaryOperator<String> operator1 = (param1, param2) -> "param1 = " + param1 + ", param2 = " + param2;
        String result1 = operator1.apply("zhangsan", "xiaoming");
        System.out.println(result1);


    }
}
