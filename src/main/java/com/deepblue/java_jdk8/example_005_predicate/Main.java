package com.deepblue.java_jdk8.example_005_predicate;

import com.alibaba.fastjson.JSON;
import com.sun.deploy.ui.DialogTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 */
public class Main {

    public static void main(String[] args) {

        /**
         * 原生 Predicate 接口的使用!
         */
        Predicate<Integer> predicate = num -> num > 5;

        boolean flag = predicate.test(10);
        System.out.println(predicate.test(10));

        /**
         * 创建自己的 Predicate MinePredicate
         */
        MinePredicate mine = new MinePredicate();
        List<Person> persons = new ArrayList<Person>();
        Person person1 = new Person(1L, "zhangsan", "123456", 10);
        Person person2 = new Person(2L, "lisi", "123456", 20);
        Person person3 = new Person(3L, "wangwu", "123456", 30);
        Person person4 = new Person(4L, "zhaoliu", "123456", 40);
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);

        List<Person> collect = persons.stream().filter(item -> mine.test(item)).collect(Collectors.toList());
        if(collect.size() == 0) {
            System.out.println("collect size is zero!");
        } else {
            collect.stream().forEach(item -> System.out.println(JSON.toJSONString(item)));
        }


    }
}
