package com.springboot.bootcache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

//开启基于注解的缓存
@EnableCaching
@MapperScan("com.springboot.bootcache.mapper")
@SpringBootApplication
public class Bootcache1Application {

    public static void main(String[] args) {
        SpringApplication.run(Bootcache1Application.class, args);
    }

}
