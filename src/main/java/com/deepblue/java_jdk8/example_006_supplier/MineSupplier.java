package com.deepblue.java_jdk8.example_006_supplier;

import java.util.function.Supplier;

/**
 *
 */
public class MineSupplier implements Supplier {

    @Override
    public Object get() {
        return "MineSupplier get method invoke!";
    }
}
