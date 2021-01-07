package com.tuogen.model;

import java.lang.reflect.Field;

public class Seller implements User{
    //账号id
    protected int id;
    //名字
    protected String name;
    //密码
    protected String password;
    //类型
    protected String type;
    //邮箱
    protected String email;
    //银行卡
    protected String bankCard;
    //发货地址
    protected String deliveryAddr;
    //头像
    protected String icon;

    public Seller() { }
    public Seller(int id, String name, String password, String type, String email, String bankCard, String deliveryAddr, String icon) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.type = type;
        this.email = email;
        this.bankCard = bankCard;
        this.deliveryAddr = deliveryAddr;
        this.icon = icon;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public void setDeliveryAddr(String deliveryAddr) {
        this.deliveryAddr = deliveryAddr;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public String getEmail() {
        return email;
    }

    public String getBankCard() {
        return bankCard;
    }

    public String getDeliveryAddr() {
        return deliveryAddr;
    }

    public String getIcon() {
        return icon;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", email='" + email + '\'' +
                ", bankCard='" + bankCard + '\'' +
                ", deliveryAddr='" + deliveryAddr + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
