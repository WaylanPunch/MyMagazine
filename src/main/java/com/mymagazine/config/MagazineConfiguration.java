package com.mymagazine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MagazineConfiguration {

    @Bean
    public MagazineLocaleResolver localeResolver(){
        return new MagazineLocaleResolver();
    }

    /**
     * WebMvcConfigurerAdapter已过时
     * @return
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new MagazineLoginHandlerInterceptor())
//                        .addPathPatterns("/admin/**")
//                .excludePathPatterns("/admin/login");
            }

            @Override
            public void configureViewResolvers(ViewResolverRegistry registry) {
//registry.
            }

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/home").setViewName("index");
                registry.addViewController("/admin/home").setViewName("admin/index");
            }
        };
    }
}
