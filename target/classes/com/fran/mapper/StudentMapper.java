package com.fran.mapper;



import com.fran.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {

     @Insert( "insert into student (id,pwd,name,email,address,question,answer) values (#{id},#{pwd},#{name},#{email},#{address},#{question},#{answer})")
     int save(Student student);

     @Select("select * from student where id = #{id}")
     Student get(Integer id);


     @Update("update student set pwd = #{pwd} where id = #{id}")
     void update(Integer id,String pwd);


     @Select("select * from student;")
     List<Student> getAll();


}
