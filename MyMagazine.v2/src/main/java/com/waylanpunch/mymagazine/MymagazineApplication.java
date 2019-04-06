package com.waylanpunch.mymagazine;

import com.waylanpunch.mymagazine.util.AttachmentStorageProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AttachmentStorageProperties.class)
@MapperScan("com.waylanpunch.mymagazine.dao")
public class MymagazineApplication {

    public static void main(String[] args) {
        SpringApplication.run(MymagazineApplication.class, args);
    }

}
