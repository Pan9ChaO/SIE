package com.fran.service;

import com.fran.mapper.ArticleMapper;
import com.fran.mapper.CommentMapper;
import com.fran.pojo.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public int commentNum(int id) {
        return articleMapper.getComNum(id);
    }

    @Override
    public List<Comments> getAll() {
        return commentMapper.getAll();
    }

    @Override
    public int getComId(int id) {
        return articleMapper.lastComId(id);
    }

    @Override
    public void save(Comments comments) {
        commentMapper.save(comments);
    }
}
