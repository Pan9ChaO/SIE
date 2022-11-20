package com.fran.service;

import com.fran.mapper.GoodMapper;
import com.fran.mapper.StudentMapper;
import com.fran.pojo.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements  GoodService{
    @Autowired
    private GoodMapper goodMapper;


    @Override
    public List<Good> getGoods() {
        return goodMapper.getGoods();
    }
}
