package com.fran.service;

import com.fran.pojo.Student;

import java.util.List;

public interface StudentService {
    int save(Student student);

    Student get(Integer id);


    void update(Integer id,String password);


    List<Student> getAll();
}
