package com.mymagazine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MagazineConfiguration {

    @Bean
    public MagazineLocaleResolver localeResolver(){
        return new MagazineLocaleResolver();
    }
}
