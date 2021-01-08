package com.tuogen.service;

import com.tuogen.model.Order;

import java.util.List;

public interface OrderService {

    //add order
    public boolean addOrder(Order order);

    //get orderList by startNum and end endNum
    public List<Order> getOrderList(int start, int num);

    //get order by buyerID
    public List<Order> getOrderList(int orderUserNum);

    //get orderList
    public List<Order> getOrderList();

    //del order by orderNum
    public boolean deleteOrder(long orderNum);

    //query order by orderNum
    public Order queryUser(Long orderNum);

    //update order
    public boolean updateUser(Order order);
}
