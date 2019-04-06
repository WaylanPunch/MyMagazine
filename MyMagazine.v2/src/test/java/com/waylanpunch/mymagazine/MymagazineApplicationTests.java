package com.waylanpunch.mymagazine;

import com.waylanpunch.mymagazine.dao.ArticleMapper;
import com.waylanpunch.mymagazine.pojo.Article;
import com.waylanpunch.mymagazine.pojo.ArticleExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MymagazineApplicationTests {

    @Test
    public void contextLoads() {
    }

    /*
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
    */


    @Autowired
    private ArticleMapper articleMapper;
    @Test
    public void testQueryMyBatisArticle() {
        Integer id = 1;
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

    @Test
    public void testInsertMyBatisArticle() {
        Article article=new Article();
        article.setAllowComment(true);
        article.setAllowFeed(true);
        article.setAllowPing(true);
        article.setCategories("Travel");
        article.setContent("的积分卡士大夫撒打飞机萨芬士大夫计划为爱服务");
        article.setCreated(new Date());
        article.setModified(new Date());
        article.setTitle("demo");
        article.setUserId(1);
        articleMapper.insertSelective(article);
    }
}
