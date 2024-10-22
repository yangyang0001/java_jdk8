package com.deepblue.mine_02_deepsource.example_003_minecollector;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 本程序把 Set类型的流 转换成 Map类型, 理论上没有这种转换, 因为 Map<K, V> 类型 和 Set<T> 根本就不兼容! 只能使用 Map<T, T> 存放 Set<T> 类型!
 * 本例的需求:
 * Set中的元素          ["hello", "world", "hello world"]
 * Map中的元素          {"hello"="hello", "world"="world", "hello world"="hello world"}
 */
public class MineMapCollector<T> implements Collector<T, Map<T, T>, Map<T, T>> {

    @Override
    public Supplier<Map<T, T>> supplier() {
        System.out.println("supplier invoked!");
        return HashMap<T, T>::new;
    }

    @Override
    public BiConsumer<Map<T, T>, T> accumulator() {
        System.out.println("accumulator invoked!");
        return (map, item) -> {
            map.put(item, item);
        };
    }

    @Override
    public BinaryOperator<Map<T, T>> combiner() {
        System.out.println("combiner invoked!");
        return (map1, map2) -> {
            map1.putAll(map2);
            return map1;
        };
    }

    @Override
    public Function<Map<T, T>, Map<T, T>> finisher() {
        System.out.println("finisher invoked!");
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoked!");
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.UNORDERED));
    }

    public static void main(String[] args){

        Set<String> set = new HashSet<>();
        set.add("hello");
        set.add("world");
        set.add("hello world");
        Map<String, String> collect = set.stream().collect(new MineMapCollector<>());

        System.out.println(collect);
    }
}
