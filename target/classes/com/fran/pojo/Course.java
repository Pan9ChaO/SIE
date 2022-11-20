package com.fran.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Integer id ;
    private String name;
    private String teacher;



    private Double price;

    private String appraise;

    private List<Time> Times;

    private Boolean light;
}
