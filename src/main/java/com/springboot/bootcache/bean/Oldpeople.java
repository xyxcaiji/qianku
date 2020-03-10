package com.springboot.bootcache.bean;

import java.sql.Date;

public class Oldpeople {
   private Integer id;
    private String old_name;
    private Integer old_age;
    private String old_sex;
    private  Date old_birthday;

    private String old_homeaddress;
    private String old_son;
    private String old_sonphone;
    private  Integer old_homeport;

    private Integer old_nurseid;
    private Date old_joindate;


    public Integer getOld_nurseid() {
        return old_nurseid;
    }

    public void setOld_nurseid(Integer old_nurseid) {
        this.old_nurseid = old_nurseid;
    }

    public Date getOld_joindate() {
        return old_joindate;
    }

    public void setOld_joindate(Date old_joindate) {
        this.old_joindate = old_joindate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOld_name() {
        return old_name;
    }

    public void setOld_name(String old_name) {
        this.old_name = old_name;
    }

    public Integer getOld_age() {
        return old_age;
    }

    public void setOld_age(Integer old_age) {
        this.old_age = old_age;
    }

    public String getOld_sex() {
        return old_sex;
    }

    public void setOld_sex(String old_sex) {
        this.old_sex = old_sex;
    }

    public Date getOld_birthday() {
        return old_birthday;
    }

    public void setOld_birthday(Date old_birthday) {
        this.old_birthday = old_birthday;
    }


    public String getOld_homeaddress() {
        return old_homeaddress;
    }

    public void setOld_homeaddress(String old_homeaddress) {
        this.old_homeaddress = old_homeaddress;
    }

    public String getOld_son() {
        return old_son;
    }

    public void setOld_son(String old_son) {
        this.old_son = old_son;
    }

    public String getOld_sonphone() {
        return old_sonphone;
    }

    public void setOld_sonphone(String old_sonphone) {
        this.old_sonphone = old_sonphone;
    }

    public Integer getOld_homeport() {
        return old_homeport;
    }

    public void setOld_homeport(Integer old_homeport) {
        this.old_homeport = old_homeport;
    }

    @Override
    public String toString() {
        return "Oldpeople{" +
                "id=" + id +
                ", old_name='" + old_name + '\'' +
                ", old_age=" + old_age +
                ", old_sex='" + old_sex + '\'' +
                ", old_birthday=" + old_birthday +
                ", old_homeaddress='" + old_homeaddress + '\'' +
                ", old_son='" + old_son + '\'' +
                ", old_phone='" + old_sonphone + '\'' +
                ", old_homeport=" + old_homeport +
                ", old_nurseid=" + old_nurseid +
                ", old_joindate=" + old_joindate +
                '}';
    }
}
