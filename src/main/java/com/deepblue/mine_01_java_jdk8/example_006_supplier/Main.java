package com.deepblue.mine_01_java_jdk8.example_006_supplier;

import java.util.Random;
import java.util.function.Supplier;

/**
 *
 */
public class Main {

    public static void main(String[] args) {

        Supplier<Integer> supplier = () -> new Random().nextInt(10);

        System.out.println(supplier.get());

        MineSupplier mine = new MineSupplier();
        System.out.println(mine.get());

        Supplier<Person> person = Person::new;
        person.get().setId(10L);

    }
}
