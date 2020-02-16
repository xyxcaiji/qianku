package com.springboot.bootcache.mycontroller;

import com.alibaba.fastjson.JSONObject;
import com.springboot.bootcache.bean.Goods;
import com.springboot.bootcache.bean.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class ZuJi {

    @Autowired
    RedisTemplate<Object, Time> timeRedisTemplate;
    @Autowired
    StringRedisTemplate redisTemplate;

    @ResponseBody
    @RequestMapping("/zuji")
    public ArrayList zuji(Model model)
    {
        Set<Time> times = timeRedisTemplate.opsForZSet().range("1", 0, -1);

       // List<Time> range = timeRedisTemplate.opsForList().range("1", 0, -1);
//        Object o = JSONObject.toJSON(times);
        ArrayList<Time> times1 = new ArrayList<>();
        Iterator<Time> iterator = times.iterator();
        while (iterator.hasNext())
        {
            times1.add(iterator.next());
        }
        Collections.reverse(times1);
        model.addAttribute("times",times1);
//        model.addAttribute("times",times);
//        System.out.println(times);
        System.out.println(times1);

        return times1;
    }

}
