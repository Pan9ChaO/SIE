package com.fran.service;

import com.fran.pojo.Articles;

import java.util.List;

public interface ArticleService {

    List<Articles> getAll();

    Articles get(Integer id);

    List<Articles> getByTitle(String title);

    List<Articles> getByName(String name);

    List<Articles> getByTag(String tag);

    void save(Articles article);
}
