package com.tuogen.dao;

import com.tuogen.model.Order;
import com.tuogen.model.OrderQuery;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    public void addOrder(Order order) throws SQLException;

    public List<Order> getOrderList(int start, int num) throws SQLException;

    public List<Order> getOrderList() throws SQLException;

    public boolean deleteOrder(long orderNum) throws SQLException;

    public Order queryOrderByOrderNum(Long orderNum) throws SQLException;

    public Order queryOrderByUserID(int BuyerID) throws SQLException;

    public boolean updateUser(Order order) throws SQLException;

    public List<Order> getOrderListByBuyerID(int buyerID) throws SQLException;

    public List<Order> getOrderListByMerchantID(int merchantID) throws SQLException;

    public List<OrderQuery> getOrderQueryListMer(int merchantID) throws SQLException;

    public List<Order> creatOder(int userID, List<Integer> goodsID) throws SQLException;

    public boolean updateUser(long orderID, String status) throws SQLException;

    public List<Integer> getGoodsByGoodListID(int goodsListId) throws SQLException;

    public  List<OrderQuery> getOrderQueryListMerByBuyer(int id) throws SQLException;
}
