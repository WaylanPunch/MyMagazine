package com.mymagazine;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;


@MapperScan("com.mymagazine.dao")
@SpringBootApplication(scanBasePackages = {"com.mymagazine"})
@EnableTransactionManagement
@EnableSwagger2
public class MyMagazineApplication {



    public static void main(String[] args) {
        SpringApplication.run(MyMagazineApplication.class, args);
    }
}
