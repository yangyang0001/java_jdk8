package com.deepblue.mine_01_java_jdk8.example_010_consumer_biconsumer;

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

    private Integer gender;

}
