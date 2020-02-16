package com.springboot.bootcache.mapper;

import com.springboot.bootcache.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.data.annotation.Id;

@Mapper
public interface UserMapper {

    @Select("select * from user where user_id=#{user_id}")
    public User getUserById(Integer user_id);
//    @Update("upadte user set user_head=#{user_head} whrer user_id=#{user_id}")
//    public void update(User user);
    //标记自增主键为什么，增加数据后会自动返回主键的值
    @Options(useGeneratedKeys = true,keyProperty = "user_id")
    @Insert("insert into user(user_sex,user_head) values(#{user_sex},#{user_head})")
    public void insert(User user);
}
