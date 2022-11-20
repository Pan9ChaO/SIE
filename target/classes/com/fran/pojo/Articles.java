package com.fran.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Articles {
    private Integer id;

    private Integer author;


    private Date date;

    private String tag;

    private String context;

    private String title;

    private String name;

    private Integer comNum;

    private String date2;

}


