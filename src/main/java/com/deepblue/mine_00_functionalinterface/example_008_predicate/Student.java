package com.deepblue.mine_00_functionalinterface.example_008_predicate;

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

    private Integer score;

}
