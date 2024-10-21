package com.deepblue.mine_01_java_jdk8.example_005_predicate;

import java.util.function.Predicate;

/**
 *
 */
public class MinePredicate implements Predicate<Person> {

    @Override
    public boolean test(Person person) {

        return person.getAge() > 30;
    }
}
