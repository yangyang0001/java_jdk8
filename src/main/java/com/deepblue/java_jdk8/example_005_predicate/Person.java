package com.deepblue.java_jdk8.example_005_predicate;

import lombok.*;

/**
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Person {

    private Long id;

    private String name;

    private String pass;

    private Integer age;
}
