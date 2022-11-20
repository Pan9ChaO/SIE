package com.fran.mapper;


import com.fran.pojo.Credit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
@Mapper
public interface CreditMapper {

    @Select("select *from credit where number = #{number}")
    Credit get(BigInteger number);



}
