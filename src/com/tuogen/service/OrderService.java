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

    /**
     * 生成订单
     * @param userID 用户ID
     * @param goodsID 商品编号
     * @return 生成的订单
     */
    Order createOrder(int userID, List<Integer> goodsID);

    /**
     * 支付订单
     * @param orderID 订单编号
     * @return 支付是否成功
     */
    boolean payOrder(int orderID);
}
