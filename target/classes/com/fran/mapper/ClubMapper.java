package com.fran.mapper;

import com.fran.pojo.Club;
import com.fran.pojo.Temp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface ClubMapper {

    @Select("select id,name,count,president,(select name from student where id = president) as stuName,des from clubs;")
    List<Club> getClubs();

    @Select("select id,name,count,president,(select name from student where id = president) as stuName,des from clubs where name like CONCAT('%',#{name},'%');")
    List<Club> getByName(String name);

    @Select("select id,name,count,president,stuName, des from (select id,name,count,president,(select name from student where id = president) as stuName,des from clubs) " +
            "as temptable where stuName = #{stuName};")
    List<Club> getByPresident(String stuName);

    @Select("select cId from clubDetail where stuId = #{stuId};" )
    List<Integer> getClubId(int stuId);


    @Select("select stuId from clubDetail where cId = #{cId}")
    List<Integer> getStudentId(int cId);

    @Insert("insert into clubDetail (cId,stuId) values (#{cId},#{stuId});")
    int save(int stuId,int cId);


    @Update("update clubs set count = count+1 where id = #{cId}")
    void increase(int cId);

    @Insert("insert into clubs (name,count,president,des) values(#{name},#{count},#{president},#{des});")
    int create(String name,int count,int president,String des);


    @Select("select id from clubs where president = #{stuId} and name = #{name}")
    List<Integer> getClubRecent(int stuId, String name);


    @Select("select des from clubs where name = #{name}")
    Temp exist(String name);
}
