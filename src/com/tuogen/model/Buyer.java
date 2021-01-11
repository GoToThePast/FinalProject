package com.tuogen.model;


public class Buyer implements User {

  private long id;
  private String name;
  private String picUrl;
  private String pwd;
  private String email;
  private String homeAddress;
  private String phoneNum;
  @Override
  public String toString() {
    return "用户名"+name+"电子邮箱"+email;
  }

  public Buyer() {
  }

  public Buyer(long id, String name, String picUrl, String pwd, String email, String homeAddress, String phoneNum) {
    this.id = id;
    this.name = name;
    this.picUrl = picUrl;
    this.pwd = pwd;
    this.email = email;
    this.homeAddress = homeAddress;
    this.phoneNum = phoneNum;
  }

  public String getPhoneNum() {
    return phoneNum;
  }

  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPicUrl() {
    return picUrl;
  }

  public void setPicUrl(String picUrl) {
    this.picUrl = picUrl;
  }


  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getHomeAddress() {
    return homeAddress;
  }

  public void setHomeAddress(String homeAddress) {
    this.homeAddress = homeAddress;
  }

}
