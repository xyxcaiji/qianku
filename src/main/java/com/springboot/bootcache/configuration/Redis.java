package com.springboot.bootcache.configuration;
/**
 * redis 添加序列化
 *
 * 如果不用这个  它存redis数据库的时候就会用jdk序列化，我们需要用jackson2序列化，这样才能让我们看懂，不至于乱码
 */
/**
 * 会出现这样的乱码
 \xAC\xED\x00\x05sr\x00&com.springboot.bootcache.bean.EmployeeFg-\xD8\xA7\
 xB3v\x13\x02\x00\x05L\x00\x03dIdt\x00\x13Ljava/lang/Integer;L\x00\x05emai
 lt\x00\x12Ljava/lang/String;L\x00\x06genderq\x00~\x00\x01L\x00\x02idq\x00~
 \x00\x01L\x00\x08lastNameq\x00~\x00\x02xpsr\x00\x11java.lang.Integer\x12\x
 E2\xA0\xA4\xF7\x81\x878\x02\x00\x01I\x00\x05valuexr\x00\x10java.lang.Number
 \x86\xAC\x95\x1D\x0B\x94\xE0\x8B\x02\x00\x00xp\x00\x00\x00\x01t\x00\x081@qq
 .comq\x00~\x00\x06q\x00~\x00\x06t\x00\x06\xE5\xBC\xA0\xE4\xB8\x89
 */
import com.springboot.bootcache.bean.Employee;
import com.springboot.bootcache.bean.Goods;
import com.springboot.bootcache.bean.Time;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

@Configuration
public class Redis {
    //自定义操作employee的
    @Bean
    public RedisTemplate<Object, Employee> empRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Employee> template = new RedisTemplate<Object, Employee>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Employee> ser = new Jackson2JsonRedisSerializer<Employee>(Employee.class);
        template.setDefaultSerializer(ser);


        return template;
    }
    //CacheManagerCustomizers可以来定制缓存的一些规则
   // @Primary  //将某个缓存管理器作为默认的
    @Bean
    public RedisCacheManager employeeCacheManager(RedisTemplate<Object, Employee> empRedisTemplate){
        RedisCacheManager cacheManager = new RedisCacheManager(empRedisTemplate);
        //key多了一个前缀

        //使用前缀，默认会将CacheName作为key的前缀
        cacheManager.setUsePrefix(true);
//        Map<String,Long> expires=new HashMap<>();
//        expires.put("1m",60*1L);
//        cacheManager.setExpires(expires);
        return cacheManager;
    }

//    //自定义操作department的
//    @Bean
//    public RedisTemplate<Object, Department> departRedisTemplate(
//            RedisConnectionFactory redisConnectionFactory)
//            throws UnknownHostException {
//        RedisTemplate<Object, Department> template = new RedisTemplate<Object, Department>();
//        template.setConnectionFactory(redisConnectionFactory);
//        Jackson2JsonRedisSerializer<Department> ser = new Jackson2JsonRedisSerializer<Department>(Department.class);
//        template.setDefaultSerializer(ser);
//        return template;
//    }
//    @Bean
//    public RedisCacheManager departtCacheManager(RedisTemplate<Object, Department> departRedisTemplate){
//        RedisCacheManager cacheManager = new RedisCacheManager(departRedisTemplate);
//        //key多了一个前缀
//
//        //使用前缀，默认会将CacheName作为key的前缀
//        cacheManager.setUsePrefix(true);
//
//        return cacheManager;
//    }

    //自定义操作Goods的

    @Bean
    public RedisTemplate<Object, Goods> goodsRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Goods> template = new RedisTemplate<Object, Goods>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Goods> ser = new Jackson2JsonRedisSerializer<Goods>(Goods.class);
        template.setDefaultSerializer(ser);
        return template;
    }
    @Primary
    @Bean
    public RedisCacheManager goodsCacheManager(RedisTemplate<Object, Goods> goodsRedisTemplate){
        RedisCacheManager cacheManager = new RedisCacheManager(goodsRedisTemplate);
        //key多了一个前缀

        //使用前缀，默认会将CacheName作为key的前缀
        cacheManager.setUsePrefix(true);

        return cacheManager;
    }
    //自定义time 的
    @Bean
    public RedisTemplate<Object, Time> timeRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Time> template = new RedisTemplate<Object, Time>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Time> ser = new Jackson2JsonRedisSerializer<Time>(Time.class);
        template.setDefaultSerializer(ser);
        return template;
    }

}
