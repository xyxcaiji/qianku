package com.springboot.bootcache.mytest;

import com.springboot.bootcache.bean.AliyunOssProperties;
import com.springboot.bootcache.bean.Employee;
import com.springboot.bootcache.bean.Goods;
import com.springboot.bootcache.mapper.EmployeeMapper;
import com.springboot.bootcache.mapper.GoodsMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

@Controller
public class Mytest {
    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    StringRedisTemplate sRedis;

    @Autowired
    RedisTemplate redisTemplate;
    //自己实现的redistemplete
    @Autowired
    RedisTemplate<Object,Employee> employeeRedisTemplate;
    /**
     * redis常见5大类型
     * string    sRedis.opsForValue();
     * list    sRedis.opsForList();
     * hash散列  sRedis.opsForHash();
     * set无序集合 sRedis.opsForSet();
     * zset有序集合  sRedis.opsForHash();
     */

    @ResponseBody
    @GetMapping("/redis")
    public String tt1()
    {
        //sRedis.opsForValue().append("msg","word");
        String msg = sRedis.opsForValue().get("msg");

        return msg;
    }

    @ResponseBody
    @GetMapping("/redis2")
    public String tt11()
    {
        Employee employee=employeeMapper.getByid(1);
        //sRedis.opsForValue().append("msg","word");
        //String msg = sRedis.opsForValue().get("msg");
       // redisTemplate.opsForValue().set("emp-01",employee);
        employeeRedisTemplate.opsForValue().set("emp-01",employee);

        return "success";
    }

    @Autowired
    RedisTemplate<Object,Goods> goodsRedisTemplate;

    @ResponseBody
    @GetMapping("/redis3")
    public Goods t2()
    {
        Goods goods = goodsMapper.getGoodsById(1);
        goodsRedisTemplate.expire("zhangsan2",120, TimeUnit.SECONDS);
        goodsRedisTemplate.opsForHash().put("zhangsan2","1",goods);

        Goods goods11 = (Goods) goodsRedisTemplate.opsForHash().get("zhangsan2", "1");


        return goods11;
    }

}
