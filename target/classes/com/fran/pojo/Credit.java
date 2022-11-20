package com.fran.pojo;

import com.fasterxml.jackson.databind.node.BigIntegerNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Credit {
    private String name;
    private BigInteger number;
    private int cvv;

}
