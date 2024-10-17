package com.deepblue.java_jdk8.example_009_method_reference;

import lombok.*;

import java.util.function.Supplier;

/**
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Student {

    private Long id;

    private String name;

    private String pass;

    private Integer age;

    public static int compare(Student student1, Student student2) {
        return student1.getAge() - student2.getAge();
    }

    public int compareAge(Student student) {
        return this.getAge() - student.getAge();
    }
}
