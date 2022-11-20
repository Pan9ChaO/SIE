package com.fran.mapper;


import com.fran.pojo.Good;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GoodMapper {

    @Select("select * from goods;")
    List<Good> getGoods();
}
