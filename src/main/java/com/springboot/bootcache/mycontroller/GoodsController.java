package com.springboot.bootcache.mycontroller;


import com.springboot.bootcache.bean.Goods;
import com.springboot.bootcache.bean.Time;
import com.springboot.bootcache.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RestController
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    RedisTemplate<Object,Time> timeRedisTemplate;
    @Autowired
    StringRedisTemplate redisTemplate;


    @ResponseBody
    @GetMapping("/goods/{id}")
    public Goods getGoodsByid(@PathVariable("id") Integer id, HttpServletRequest request)
    {
        //获得uesr_id
      //  Integer user_id = (Integer) request.getSession().getAttribute("user_id");

        //获得当前时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddHHmmssSSS");
        String date = simpleDateFormat.format(new Date());

        double v = Double.parseDouble(date);
      //  System.out.println(v);
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = simpleDateFormat1.format(new Date());

        Goods goods = goodsService.getByid(id);

        Time time=new Time(date1,goods);
       // System.out.println(byid.toString());
        timeRedisTemplate.expire("1",31, TimeUnit.DAYS);
        Boolean zhangsan = timeRedisTemplate.opsForZSet().add("1", time, v);


        return goods;

    }

    @ResponseBody
    @RequestMapping("/goods")
    public Goods update(Goods goods)
    {
        goods.setGoods_id(1);
        goods.setGoods_name("lisi");
        Goods goods1 = goodsService.update(goods);
        return goods1;
    }

    @ResponseBody
    @RequestMapping("/goods/delete/{goods_id}")
    public String delete(@PathVariable("goods_id") Integer goods_id)
    {
        goodsService.delete(goods_id);
        return "success";
    }


}
