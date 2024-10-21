package com.deepblue.mine_01_java_jdk8.example_008_optional;

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
