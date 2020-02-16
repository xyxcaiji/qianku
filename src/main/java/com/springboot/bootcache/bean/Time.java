package com.springboot.bootcache.bean;

import java.util.Date;

public class Time {
    private String  date;
    private Goods goods;
    public Time()
    {

    }
    public Time(String date,Goods goods)
    {
        this.date=date;
        this.goods=goods;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "Time{" +
                "date=" + date +
                ", goods=" + goods +
                '}';
    }
}

