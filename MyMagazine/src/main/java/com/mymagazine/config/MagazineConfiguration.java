package com.mymagazine.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.*;

import java.lang.reflect.Method;
import java.net.UnknownHostException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MagazineConfiguration {

    @Bean
    public MagazineLocaleResolver localeResolver() {
        return new MagazineLocaleResolver();
    }

    /**
     * WebMvcConfigurerAdapter已过时
     *
     * @return
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
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

    /*
    @Bean("magazineCacheKey")
    public KeyGenerator magazineCacheKey(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }
    */

    /**
     * custom info for actuator
     *
     * @return
     */
    @Bean
    public InfoContributor infoContributor() {
        return new InfoContributor() {
            @Override
            public void contribute(Info.Builder builder) {
                Map<String, Object> details = new HashMap<>();
                details.put("App Name", "Magazine");
                details.put("Developer", "Waylan Punch");
                details.put("Description", "A Magazine Web App, Build With SpringBoot.");
                builder.withDetails(details).build();
            }
        };
    }
}
