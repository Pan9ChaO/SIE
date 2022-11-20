package com.fran.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubDetails {
    private Integer cId;

    private String stuName;

    private Integer stuId;
}
