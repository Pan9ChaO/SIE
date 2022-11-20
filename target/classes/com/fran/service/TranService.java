package com.fran.service;

import com.fran.pojo.Transaction;

import java.util.List;


public interface TranService {




    int save(Transaction transaction);

    List<Transaction> getTransactions();

    List<Transaction> getByName(String name);

    int delete(long id);
}