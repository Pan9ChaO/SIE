package com.fran.mapper;


import com.fran.pojo.Transaction;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TranMapper {

    @Insert("insert into transaction (id,name,price,type,description,imagePath,authorId) values (#{id},#{name},#{price},#{type},#{description},#{imagePath},#{authorId})")
    int save(Transaction transaction);


    @Select("select * from transaction")
    List<Transaction> getTransactions();

    @Select("select * from transaction where name like CONCAT('%',#{name},'%')")
    List<Transaction> getByName(String name);

    @Delete("delete from transaction where id = #{id}")
    int delete(long id);
}
