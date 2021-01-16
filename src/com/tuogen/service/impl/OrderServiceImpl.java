package com.tuogen.service.impl;

import com.tuogen.dao.impl.OrderDaoImpl;
import com.tuogen.model.Order;
import com.tuogen.model.OrderQuery;
import com.tuogen.service.OrderService;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

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
    public List<Order> getOrderListByMerchantID(int merchantID) {
        List<Order> orderList=null;
        try {
            orderList=orderDao.getOrderListByMerchantID(merchantID);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orderList;
    }

    public List<Order> getOrderListByBuyerID(int BuyerID) {
        List<Order> orderList=null;
        try {
            orderList=orderDao.getOrderListByBuyerID(BuyerID);
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
            order= orderDao.queryOrderByOrderNum(orderNum);
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

    @Override
    public List<Order> createOrder(int userID,List<Integer> goodsID) {
        List<Order> order=null;
        try {
            order=orderDao.creatOder(userID,goodsID);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return order;
    }

    @Override
    public boolean payOrder(long orderID) {
        List<Order> order=null;
        try {
            boolean tag=orderDao.updateUser(orderID,"已付款");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public List<OrderQuery> getOrderQueryList(int merchantID) {
        List<OrderQuery> orderList=null;
        try {
            orderList=orderDao.getOrderQueryListMer(merchantID);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orderList;
    }

    @Override
    public Vector<Integer> getGoodsByGoodListID(int goodsListId) {
        Vector<Integer> goodIds=null;
        try {
            goodIds=orderDao.getGoodsByGoodListID(goodsListId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return goodIds;
    }

    @Override
    public List<OrderQuery> getOrderQueryListByBuyer(int id) {
        List<OrderQuery> orderList=null;
        try {
            orderList=orderDao.getOrderQueryListMerByBuyer(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orderList;
    }

}
