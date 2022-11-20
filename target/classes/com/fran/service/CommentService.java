package com.fran.service;

import com.fran.pojo.Comments;

import java.util.List;

public interface CommentService {

     int commentNum(int id);

     List<Comments> getAll();

     int getComId(int id);

     void save(Comments comments);
}
