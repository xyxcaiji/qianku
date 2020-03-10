package com.springboot.bootcache.configuration;

import com.springboot.bootcache.myfilter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.lang.reflect.Method;
import java.util.Arrays;
//
//@Configuration
public class Myconfig {

    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator()
    {
        return new KeyGenerator() {

            @Override
            public Object generate(Object o, Method method, Object... objects) {
                return method.getName()+"{"+ Arrays.asList(objects)+"}";
            }
        };
    }
    @Bean
    public FilterRegistrationBean myFilterRegistrationBean()
    {
        FilterRegistrationBean filter=new FilterRegistrationBean();
        filter.setFilter(new MyFilter());

        filter.addUrlPatterns("/*");
   //     String error="login.html";

        return  filter;
    }


}
