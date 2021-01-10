package com.tuogen.model;


import java.sql.Timestamp;

public class Order {
  private long orderNum;
  private int orderUserNum;
  private int goodsListId;
  private String orderStatus;
  private java.sql.Timestamp createrTime;
  private int merchantId;
  private double totalPrice;

  public  Order(){

  }

  public Order(long orderNum, int orderUserNum, int goodsListId, String orderStatus,
               Timestamp createrTime, int merchantId, double totalPrice) {
    this.orderNum = orderNum;
    this.orderUserNum = orderUserNum;
    this.goodsListId = goodsListId;
    this.orderStatus = orderStatus;
    this.createrTime = createrTime;
    this.merchantId = merchantId;
    this.totalPrice = totalPrice;
  }

  @Override
  public String toString() {
    return "ID:"+orderNum+" Buyer:"+orderUserNum+" GoodListId:"+goodsListId+" 订单状态:"+orderStatus+
            " 时间:"+createrTime+" 商家ID:"+merchantId+" 总价:"+totalPrice;
  }

  public long getOrderNum() {
    return orderNum;
  }

  public void setOrderNum(long orderNum) {
    this.orderNum = orderNum;
  }

  public int getOrderUserNum() {
    return orderUserNum;
  }

  public void setOrderUserNum(int orderUserNum) {
    this.orderUserNum = orderUserNum;
  }

  public int getGoodsListId() {
    return goodsListId;
  }

  public void setGoodsListId(int goodsListId) {
    this.goodsListId = goodsListId;
  }

  public String getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(String orderStatus) {
    this.orderStatus = orderStatus;
  }

  public Timestamp getCreaterTime() {
    return createrTime;
  }

  public void setCreaterTime(Timestamp createrTime) {
    this.createrTime = createrTime;
  }

  public int getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(int merchantId) {
    this.merchantId = merchantId;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }
}
