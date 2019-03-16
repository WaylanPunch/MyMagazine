package com.waylanpunch.mymagazine.service;

import com.waylanpunch.mymagazine.dao.ArticleMapper;
import com.waylanpunch.mymagazine.pojo.Article;
import com.waylanpunch.mymagazine.pojo.ArticleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * A New Class Created By Waylan Punch
 * https://github.com/WaylanPunch
 *
 * @author Waylan Punch
 * @date 2019/3/16 17:07
 */
@Service
public class ArticleService implements IArticleService {

    @Autowired
    private ArticleMapper articleMapper;


    @Override
    public List<Article> findAllArticles() {
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andArticleIdIsNotNull();
        return articleMapper.selectByExample(articleExample);
    }
}
