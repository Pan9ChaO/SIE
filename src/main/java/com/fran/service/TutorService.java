package com.fran.service;

import com.fran.pojo.Course;

import java.sql.Time;
import java.util.List;

public interface TutorService {

    List<Course> getCourse();

    List<Time> getTimes(String teacher,String cName);

    List<Course> getByName(String name);

    List<Course> getByTeacher(String teacher);


}
