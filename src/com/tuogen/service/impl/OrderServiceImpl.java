package com.tuogen.service.impl;

import com.tuogen.dao.impl.OrderDaoImpl;
import com.tuogen.model.Order;
import com.tuogen.service.OrderService;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderDaoImpl orderDao=new OrderDaoImpl();
    @Override
    public boolean addOrder(Order order) {
        try {
            orderDao.addOrder(order);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Order> getOrderList(int start, int num) {
        List<Order> orderList=null;
        try {
            orderList=orderDao.getOrderList(start,num);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orderList;
    }

    @Override
    public List<Order> getOrderList() {
        List<Order> orderList=null;
        try {
            orderList=orderDao.getOrderList();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orderList;
    }

    @Override
    public List<Order> getOrderList(int orderUserNum) {
        List<Order> orderList=null;
        try {
            orderList=orderDao.getOrderList(orderUserNum);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orderList;
    }

    @Override
    public boolean deleteOrder(long orderNum) {
        boolean tag=true;
        try {
           tag= orderDao.deleteOrder(orderNum);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tag;
    }

    @Override
    public Order queryUser(Long orderNum) {
        Order order=null;
        try {
            order= orderDao.queryUser(orderNum);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return order;
    }

    @Override
    public boolean updateUser(Order order) {
        boolean tag=true;
        try {
            tag= orderDao.deleteOrder(order.getOrderNum());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tag;
    }
}
