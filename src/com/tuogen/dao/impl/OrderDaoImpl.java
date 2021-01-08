package com.tuogen.dao.impl;


import com.tuogen.dao.OrderDao;
import com.tuogen.model.Order;
import com.tuogen.utils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public void addOrder(Order order) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement =JDBCUtils.getConnection().prepareStatement("insert into `order` values(?,?,?,?,?,?,?)");
        setOrderInfo(order, statement);
        statement.executeUpdate();
        JDBCUtils.close(connection,statement);
    }

    @Override
    public List<Order> getOrderList(int start, int num) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from `order` limit ?,?");
        statement.setInt(1,start);
        statement.setInt(2,num);
        ResultSet resultSet = statement.executeQuery();
        List<Order> list=new ArrayList<>();
        while (resultSet.next()){
            Order order=new Order();
            getOrderInfo(resultSet, order);
            list.add(order);
        }
        JDBCUtils.close(connection,statement,resultSet);
        return list;
    }

    @Override
    public List<Order> getOrderList(int orderUserNum) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from `order` where orderUserNum=?");
        statement.setInt(1,orderUserNum);
        ResultSet resultSet = statement.executeQuery();
        List<Order> list=new ArrayList<>();
        while (resultSet.next()){
            Order order=new Order();
            getOrderInfo(resultSet, order);
            list.add(order);
        }
        JDBCUtils.close(connection,statement,resultSet);
        return list;
    }

    @Override
    public List<Order> getOrderList() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from `order`");
        ResultSet resultSet = statement.executeQuery();
        List<Order> list=new ArrayList<>();
        while (resultSet.next()){
            Order order=new Order();
            getOrderInfo(resultSet, order);
            list.add(order);
        }
        JDBCUtils.close(connection,statement,resultSet);
        return list;
    }

    @Override
    public boolean deleteOrder(long orderNum) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("delete from `order` where orderNum=?");
        statement.setLong(1,orderNum);
        int i = statement.executeUpdate();
        JDBCUtils.close(connection,statement);
        return i==1?true:false;
    }

    @Override
    public Order queryUser(Long orderNum) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from `order` where userID=?");
        statement.setLong(1,orderNum);
        ResultSet resultSet = statement.executeQuery();
        Order order=new Order();
        while (resultSet.next()){
            getOrderInfo(resultSet, order);
        }
        JDBCUtils.close(connection,statement,resultSet);
        return order;
    }

    @Override
    public boolean updateUser(Order order) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement(
                "update `order` set orderNum=?,orderUserNum=?,goodsListID=?,orderStatus=?,createrTime=?,merchantID=?, totalPrice=?" +
                        "  where orderNum=?");
        setOrderInfo(order, statement);
        statement.setLong(7,order.getOrderNum());
        int i= statement.executeUpdate();
        JDBCUtils.close(connection,statement);
        return i==1?true:false;
    }

    private void getOrderInfo(ResultSet resultSet, Order order) throws SQLException{
        order.setOrderNum(resultSet.getLong(1));
        order.setOrderUserNum(resultSet.getInt(2));
        order.setGoodsListId(resultSet.getInt(3));
        order.setOrderStatus(resultSet.getString(4));
        order.setCreaterTime(resultSet.getTimestamp(5));
        order.setMerchantId(resultSet.getInt(6));
        order.setTotalPrice(resultSet.getDouble(7));
    }

    private void setOrderInfo(Order order, PreparedStatement statement) throws SQLException{
        statement.setLong(1,order.getOrderNum());
        statement.setInt(2,order.getOrderUserNum());
        statement.setInt(3,order.getGoodsListId());
        statement.setString(4,order.getOrderStatus());
        statement.setTimestamp(5,order.getCreaterTime());
        statement.setInt(6,order.getMerchantId());
        statement.setDouble(7,order.getTotalPrice());
    }
}
