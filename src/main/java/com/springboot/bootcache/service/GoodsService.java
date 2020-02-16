package com.springboot.bootcache.service;

import com.springboot.bootcache.bean.Employee;
import com.springboot.bootcache.bean.Goods;
import com.springboot.bootcache.bean.User;
import com.springboot.bootcache.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "goods"/*,cacheManager = "goodsCacheManager"*/)
@Service
public class GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Cacheable(/*key = "#result.goods_id"*/)
    public Goods getByid(Integer goods_id)
    {

        Goods goods = goodsMapper.getGoodsById(goods_id);

        System.out.println("service............"+goods);
        return goods;
    }

    @CachePut(key = "#result.goods_id")
    public Goods update(Goods goods)
    {
        System.out.println("goods"+goods);
        goodsMapper.update(goods);
        return goods;
    }
    @CacheEvict(beforeInvocation = true/*key = "#id",*/)
    public  void delete(Integer goods_id)
    {
        goodsMapper.delete(goods_id);
    }

//    // @Caching 定义复杂的缓存规则
//    @Caching(
//            cacheable = {
//                    @Cacheable(/*value="emp",*/key = "#lastName")
//            },
//            put = {
//                    @CachePut(/*value="emp",*/key = "#result.id"),
//                    @CachePut(/*value="emp",*/key = "#result.email")
//            }
//    )
//    public Employee getEmpByLastName(String lastName){
//        return employeeMapper.getEmpByLastName(lastName);
//    }

}
