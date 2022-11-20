package com.fran.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comments {
    private Integer articleId;
    private String title;

    private Integer comId;

    private Integer level;

    private Integer who;
    private String name;

    private String comment;

    private Date date;

    private Integer toto;
    private String toName;
    private String date2;
}
