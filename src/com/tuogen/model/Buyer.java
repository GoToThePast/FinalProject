package com.tuogen.model;


public class Buyer implements User{

  private long id;
  private String name;
  private String password;
  private String email;
  private String phoneNumber;
  private String homeAddress;
  private String picUrl;

  public Buyer() {
  }

  public Buyer(String name, String password, String email, String phoneNumber, String homeAddress, String picUrl) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.homeAddress = homeAddress;
    this.picUrl = picUrl;
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


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }


  public String getHomeAddress() {
    return homeAddress;
  }

  public void setHomeAddress(String homeAddress) {
    this.homeAddress = homeAddress;
  }


  public String getPicUrl() {
    return picUrl;
  }

  public void setPicUrl(String picUrl) {
    this.picUrl = picUrl;
  }

}
