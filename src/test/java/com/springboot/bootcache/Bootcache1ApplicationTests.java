package com.springboot.bootcache;

import com.springboot.bootcache.bean.AliyunOssProperties;
import com.springboot.bootcache.bean.Employee;
import com.springboot.bootcache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Bootcache1ApplicationTests {

    @Autowired
    AliyunOssProperties aliyunOssProperties;

    @Test
    public void contextLoads() {
        System.out.println(aliyunOssProperties.getEndpoint());

    }

}
