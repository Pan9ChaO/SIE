package com.fran.mapper;


import com.fran.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.List;

@Mapper
@Repository
public interface TutorMapper {


    @Select("select * from course;")
    List<Course> getCourse();


    @Select("select date from courseTime where teacher = #{teacher} and cName = #{cName}; ")
    List<Time> getTimes(String teacher , String cName);

    @Select("select * from course where name like CONCAT('%',#{title},'%')")
    List<Course> getByName(String name);

    @Select("select * from course where teacher = #{teacher};")
    List<Course> getByTeacher(String teacher);
}
