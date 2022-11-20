package com.fran.mapper;


import com.fran.pojo.Articles;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleMapper {

    @Select("select * from articles;")
    List<Articles> getAll();


    @Select("select count(*) from comments where articleId = #{articleId};")
    int getComNum(int articleId);


    @Select("select * from articles where id = #{id}")
    Articles get(Integer id);

    @Select("select * from articles where title like CONCAT('%',#{title},'%')")
    List<Articles> getByTitle(String title);

    @Select("select * from articles where name = CONCAT(#{name})")
    List<Articles> getByName(String name);

    @Select("select * from articles where tag = CONCAT(#{tag})")
    List<Articles> getByTag(String tag);

    @Select("select comId from comments where articleId = #{articleId} order by comId desc limit 1;")
    int lastComId(int articleId);

    @Insert("insert into articles (author,date,tag,context,title) values (#{author},#{date},#{tag},#{context},#{title});")
    void save(Articles article);
}
