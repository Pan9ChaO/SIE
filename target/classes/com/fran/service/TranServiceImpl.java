package com.fran.service;

import com.fran.mapper.TranMapper;
import com.fran.pojo.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TranServiceImpl implements TranService {
    @Autowired
    private TranMapper tranMapper;


    @Override
    public int save(Transaction transaction) {
        return  tranMapper.save(transaction);
    }

    @Override
    public List<Transaction> getTransactions() {
       return tranMapper.getTransactions();
    }

    @Override
    public List<Transaction> getByName(String name) {return tranMapper.getByName(name);}

    @Override
    public int delete(long id) {
        return tranMapper.delete(id);
    }
}
