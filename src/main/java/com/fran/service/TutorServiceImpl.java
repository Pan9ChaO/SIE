package com.fran.service;

import com.fran.mapper.TutorMapper;
import com.fran.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;

@Service
public class TutorServiceImpl implements TutorService{
    @Autowired
    private TutorMapper tutorMapper;

    @Override
    public List<Course> getCourse() {
        return tutorMapper.getCourse();
    }

    @Override
    public List<Time> getTimes(String teacher,String cName) {
        return tutorMapper.getTimes(teacher,cName);
    }

    @Override
    public List<Course> getByName(String name) { return tutorMapper.getByName(name); }

    @Override
    public List<Course> getByTeacher(String teacher) { return tutorMapper.getByTeacher(teacher); }
}
