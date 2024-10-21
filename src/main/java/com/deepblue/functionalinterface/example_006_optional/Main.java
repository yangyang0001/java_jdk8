package com.deepblue.functionalinterface.example_006_optional;

import java.util.Optional;

/**
 *
 */
public class Main {

    public static void main(String[] args) {

        String param = "";
        Optional<String> optional = Optional.of(param);

        String result = optional.orElse("zhangsan");
        System.out.println("result = " + result);

        boolean present = optional.isPresent();
        System.out.println("present = " + present);

        String result1 = optional.orElse("wangwu");
        System.out.println("result1 = " + result1);

    }
}
