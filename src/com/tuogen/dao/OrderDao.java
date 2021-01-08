package com.tuogen.dao;

import com.tuogen.model.Order;

import java.sql.SQLException;
import java.util.List;
import com.tuogen.utils.*;

public interface OrderDao {
    public void addOrder(Order order) throws SQLException;

    public List<Order> getOrderList(int start, int num) throws SQLException;

    public List<Order> getOrderList(int orderUserNum) throws SQLException;

    public List<Order> getOrderList() throws SQLException;

    public boolean deleteOrder(long orderNum) throws SQLException;

    public Order queryUser(Long orderNum) throws SQLException;

    public boolean updateUser(Order order) throws SQLException;
}
