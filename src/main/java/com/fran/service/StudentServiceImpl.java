package com.fran.service;

import com.fran.mapper.StudentMapper;
import com.fran.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int save(Student student) {
        return studentMapper.save(student);
    }

    @Override
    public Student get(Integer id) {
        return studentMapper.get(id);
    }

    @Override
    public void update(Integer id, String password) {
         studentMapper.update(id,password);
    }

    @Override
    public List<Student> getAll() {
        return studentMapper.getAll();
    }
}
