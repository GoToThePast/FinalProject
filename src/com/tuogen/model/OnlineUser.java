package com.tuogen.model;

public class OnlineUser {
    //用户属性
    private Type type;
    //用户
    private User user;
    //登录时间
    private String date;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public OnlineUser(Type type, User user, String date) {
        this.type = type;
        this.user = user;
        this.date = date;
    }
}
