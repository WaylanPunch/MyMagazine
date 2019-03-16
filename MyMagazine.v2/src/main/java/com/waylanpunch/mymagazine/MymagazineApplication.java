package com.waylanpunch.mymagazine;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.waylanpunch.mymagazine.dao")
public class MymagazineApplication {

    public static void main(String[] args) {
        SpringApplication.run(MymagazineApplication.class, args);
    }

}
