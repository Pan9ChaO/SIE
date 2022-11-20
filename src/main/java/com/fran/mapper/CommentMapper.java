package com.fran.mapper;


import com.fran.pojo.Comments;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {

    @Select("select * from comments order by date desc;")
    List<Comments> getAll();


    @Insert("insert into comments (articleId,comId,level,who,comment,date,toto) values (#{articleId},#{comId},#{level},#{who},#{comment},#{date},#{toto})")
    void save(Comments comments);
}
