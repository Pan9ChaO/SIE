package com.fran.service;

import com.fran.pojo.Credit;
import com.fran.pojo.Student;

import java.math.BigInteger;

public interface CreditService {
    Credit get(BigInteger number);
}
