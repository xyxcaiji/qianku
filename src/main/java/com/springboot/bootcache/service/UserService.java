package com.springboot.bootcache.service;

import com.springboot.bootcache.bean.User;
import com.springboot.bootcache.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "user")
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Cacheable(key = "#user_id")
    public User getByid(Integer user_id)
    {
        User userById = userMapper.getUserById(user_id);
        System.out.println("service"+userById);
        return userById;
    }


    public void insrt(User user)
    {
        userMapper.insert(user);
        System.out.println("添加的信息"+user.toString());
    }


}
