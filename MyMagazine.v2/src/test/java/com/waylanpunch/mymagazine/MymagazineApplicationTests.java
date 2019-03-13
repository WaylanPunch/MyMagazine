package com.waylanpunch.mymagazine;

import com.waylanpunch.mymagazine.dao.ArticleMapper;
import com.waylanpunch.mymagazine.pojo.Article;
import com.waylanpunch.mymagazine.pojo.ArticleExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MymagazineApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void generatorMyBatis() {
        try {
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            File configFile = new File("src/main/resources/generatorConfig.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (XMLParserException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Autowired
    private ArticleMapper articleMapper;

    @Test
    public void testMyBatisArticle() {
        Integer id = 2;
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andArticleIdEqualTo(id);
        List<Article> articles = articleMapper.selectByExample(articleExample);
        if (null != articles && articles.size() > 0) {
            System.out.println("Title : " + articles.get(0).getTitle());
            System.out.println("Categories : " + articles.get(0).getCategories());
            System.out.println("Content : " + articles.get(0).getContent());
            System.out.println("Slug : " + articles.get(0).getSlug());
            System.out.println("Status : " + articles.get(0).getStatus());
            System.out.println("Tags : " + articles.get(0).getTags());
            System.out.println("Created : " + articles.get(0).getCreated());
            System.out.println("Modified : " + articles.get(0).getModified());
        }
    }
}
