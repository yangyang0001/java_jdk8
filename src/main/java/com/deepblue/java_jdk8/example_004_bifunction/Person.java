package com.deepblue.java_jdk8.example_004_bifunction;

import lombok.*;

import javax.xml.ws.WebFault;

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
