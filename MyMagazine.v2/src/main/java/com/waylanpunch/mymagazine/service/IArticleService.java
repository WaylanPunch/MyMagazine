package com.waylanpunch.mymagazine.service;

import com.waylanpunch.mymagazine.pojo.Article;

import java.util.List;

public interface IArticleService {

    List<Article> findAllArticles();
}
