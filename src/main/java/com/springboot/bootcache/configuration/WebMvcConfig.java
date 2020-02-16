package com.springboot.bootcache.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        //浏览器发送@硅谷请求来到请求页面
        registry.addViewController("/atguigu").setViewName("login");
    }
//    //不用写controller写个空方法再去跳转页面
//    @Bean
//    public WebMvcConfigurerAdapter webMvcConfigurerAdapter()
//    {
//        WebMvcConfigurerAdapter webMvcConfigurerAdapter= new WebMvcConfigurerAdapter(){
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/login.html").setViewName("login");
//            }
//        };
//
//        return  webMvcConfigurerAdapter;
//    }

}
