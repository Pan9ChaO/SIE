package com.fran.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    private Long id;

    private String name;

    private double price;

    private Integer type;


    private String description;


    private String imagePath;

    private Integer authorId;
}
