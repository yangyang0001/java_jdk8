package com.deepblue.mine_00_functionalinterface.example_008_predicate;

import org.apache.commons.lang3.StringUtils;

import java.util.function.Predicate;

/**
 *
 */
public class Main {

    public static void main(String[] args) {

        String param = "";
        System.out.println("param is empty = " + param.isEmpty());            // true
        param = null;
        System.out.println("param is blank = " + StringUtils.isBlank(param)); // true

        if(null != param) {
            System.out.println("param is not null");
        } else {
            System.out.println("param is null");
        }

        // 引入 判断真假函数 Predicate

        Predicate<String> predicate = item -> StringUtils.isBlank(item);
        System.out.println(predicate.test(param));

        Predicate<Student> predicate1 = item -> item.getAge() > 10;
        boolean flag = predicate1.test(new Student(2L, "wangfang", "222", 0, 25, 2L, 55));
        System.out.println("flag = " + flag);

    }
}
