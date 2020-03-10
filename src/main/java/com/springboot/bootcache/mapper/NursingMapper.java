package com.springboot.bootcache.mapper;

import com.springboot.bootcache.bean.Nursing;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface NursingMapper {
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into nursing(nurse_name,nurse_sex,nurse_birthday,nurse_politic,nurse_joindate,nurse_working,nurse_grada,nurse_age,nurse_phone) values(#{nurse_name},#{nurse_sex},#{nurse_birthday},#{nurse_politic},#{nurse_joindate},#{nurse_working},#{nurse_grada},#{nurse_age},#{nurse_phone})")
    public void insert(Nursing nursing);

    @Select("select * from nursing where nurse_name=#{nurse_name}")
    public  Nursing selectByName(String nurse_name);

    @Select("select * from nursing")
    public ArrayList<Nursing> selectAll();

    @Delete("delete from nursing where id=#{id}")
    public void delete(Integer id);

    @Update("update nursing set nurse_name=#{nurse_name},nurse_age=#{nurse_age},nurse_sex=#{nurse_sex},nurse_birthday=#{nurse_birthday},nurse_politic=#{nurse_politic},nurse_joindate=#{nurse_joindate},nurse_working=#{nurse_working},nurse_grada=#{nurse_grada},nurse_phone=#{nurse_phone} where id=#{id}")
    public void update(Nursing nursing);
}
