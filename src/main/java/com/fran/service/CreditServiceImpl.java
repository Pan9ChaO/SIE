package com.fran.service;


import com.fran.mapper.CreditMapper;
import com.fran.pojo.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class CreditServiceImpl implements CreditService{
    @Autowired
    private CreditMapper creditMapper;

    @Override
    public Credit get(BigInteger number) {
       return creditMapper.get(number);
    }
}
