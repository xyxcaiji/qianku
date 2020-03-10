package com.springboot.bootcache.service;

import com.springboot.bootcache.bean.Old_Nur;
import com.springboot.bootcache.bean.Oldpeople;
import com.springboot.bootcache.mapper.OldpeopleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OldSevice {
    @Autowired
    OldpeopleMapper oldpeopleMapper;

    public void update(Oldpeople oldpeople)
    {
        System.out.println("service"+oldpeople);
        oldpeopleMapper.update(oldpeople);
    }
    public void insert(Oldpeople oldpeople){
        oldpeopleMapper.insert(oldpeople);
        System.out.println(oldpeople);
    }
    public void delete(Integer id)
    {
        oldpeopleMapper.delete(id);
    }

    public Oldpeople selectByid(Integer id)
    {
        Oldpeople oldpeople = oldpeopleMapper.selectByid(id);
        return oldpeople;
    }

    public ArrayList<Old_Nur> selectAll()
    {
        ArrayList<Old_Nur> old_nurs = oldpeopleMapper.selectAll();
        return old_nurs;
    }
    //按名字查询老人
    public Oldpeople selectByname(String name)
    {
        Oldpeople oldpeople = oldpeopleMapper.selectByname(name);
        return oldpeople;
    }

    //按名字查询老人
    public Old_Nur selectByoldname(String name)
    {
        Old_Nur old_nur = oldpeopleMapper.selectByoldname(name);
        return old_nur;
    }
}
