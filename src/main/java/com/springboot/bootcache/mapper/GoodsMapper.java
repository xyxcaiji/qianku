package com.springboot.bootcache.mapper;

import com.springboot.bootcache.bean.Goods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface GoodsMapper {
    @Select("select * from goods where goods_id=#{goods_id}")
    public Goods getGoodsById(Integer goods_id);

    @Update("update goods set goods_name=#{goods_name} where goods_id=#{goods_id}")
    public void update(Goods goods);

    @Delete("delete from goods where goods_id=#{goods_id}")
    public void  delete(Integer goods_id);
}
