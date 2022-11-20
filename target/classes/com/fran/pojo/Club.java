package com.fran.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Club {



    private Integer id;

    private String name;

    private Integer count;


    private Integer president;

    private String stuName;

    private String des;

    private Boolean contain;

    private List<Student> students = new ArrayList<>();



    public void add(Student student){
        students.add(student);
    }

    public List<Student> get(){
        return students;
    }
}
