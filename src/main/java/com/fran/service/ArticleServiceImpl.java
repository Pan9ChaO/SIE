package com.fran.service;


import com.fran.mapper.ArticleMapper;
import com.fran.pojo.Articles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    private ArticleMapper  articleMapper;


    @Override
    public List<Articles> getAll() {
        return articleMapper.getAll();

    }

    @Override
    public Articles get(Integer id) {
        return articleMapper.get(id);
    }

    @Override
    public List<Articles> getByTitle(String title) {
        return articleMapper.getByTitle(title);
    }

    @Override
    public List<Articles> getByName(String name) {
        return articleMapper.getByName(name);
    }

    @Override
    public List<Articles> getByTag(String tag) {
        return articleMapper.getByTag(tag);
    }

    @Override
    public void save(Articles article) {
        articleMapper.save(article);
    }
}
