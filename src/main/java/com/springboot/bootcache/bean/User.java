package com.springboot.bootcache.bean;

import java.sql.Date;

public class User {
    private String user_name;
    private String user_password;
    private String user_email;
    private String user_phone;
    private Date   user_birth;
    private String user_sex;

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public Date getUser_birth() {
        return user_birth;
    }

    public void setUser_birth(Date user_birth) {
        this.user_birth = user_birth;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_birth=" + user_birth +
                ", user_sex='" + user_sex + '\'' +
                '}';
    }
}
