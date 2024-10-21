package com.deepblue.mine_02_deepsource.example_001_stream;

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
