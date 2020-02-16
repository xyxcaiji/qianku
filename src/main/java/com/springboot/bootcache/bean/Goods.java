package com.springboot.bootcache.bean;

import java.io.Serializable;

public class Goods implements Serializable {
    private Integer goods_id;
    private Integer store_id;
    private String  goods_name;
    private Integer godid;
    private Integer goods_price;
    private Integer goods_num;
    private Integer goods_sale;
    private String goods_pic;
    private Integer assistant_id;
    private String goods_des;

    public Goods() {
        super();
    }

    public Goods(Integer goods_id, Integer store_id, String goods_name, Integer godid, Integer goods_price, Integer goods_num, Integer goods_sale, String goods_pic, Integer assistant_id, String goods_des) {
        this.goods_id = goods_id;
        this.store_id = store_id;
        this.goods_name = goods_name;
        this.godid = godid;
        this.goods_price = goods_price;
        this.goods_num = goods_num;
        this.goods_sale = goods_sale;
        this.goods_pic = goods_pic;
        this.assistant_id = assistant_id;
        this.goods_des = goods_des;
    }

    public Integer getStore_id() {
        return store_id;
    }

    public void setStore_id(Integer store_id) {
        this.store_id = store_id;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public Integer getGodid() {
        return godid;
    }

    public void setGodid(Integer godid) {
        this.godid = godid;
    }

    public Integer getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(Integer goods_price) {
        this.goods_price = goods_price;
    }

    public Integer getGoods_num() {
        return goods_num;
    }

    public void setGoods_num(Integer goods_num) {
        this.goods_num = goods_num;
    }

    public Integer getGoods_sale() {
        return goods_sale;
    }

    public void setGoods_sale(Integer goods_sale) {
        this.goods_sale = goods_sale;
    }

    public String getGoods_pic() {
        return goods_pic;
    }

    public void setGoods_pic(String goods_pic) {
        this.goods_pic = goods_pic;
    }

    public Integer getAssistant_id() {
        return assistant_id;
    }

    public void setAssistant_id(Integer assistant_id) {
        this.assistant_id = assistant_id;
    }

    public String getGoods_des() {
        return goods_des;
    }

    public void setGoods_des(String goods_des) {
        this.goods_des = goods_des;
    }

    @Override
    public String toString() {
        return "Goods [goods_id=" +goods_id+", store_id=" + store_id +", goods_name=" + goods_name +", godid=" + godid +", goods_price=" + goods_price +", goods_num=" + goods_num +", goods_sale=" + goods_sale + ", goods_pic=" + goods_pic +", assistant_id=" + assistant_id +", goods_des=" + goods_des +"]";
    }
}
