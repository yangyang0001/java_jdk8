package com.deepblue.functionalinterface.example_009_stream;

import lombok.*;

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

    private Integer gender;

    private Integer age;

    private Long classId;

}
